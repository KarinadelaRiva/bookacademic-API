package com.bookademic.bookademic.services;

import com.bookademic.bookademic.domain.dto.role.RoleCreateDTO;
import com.bookademic.bookademic.domain.dto.role.RoleResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.role.RoleUpdateDTO;
import com.bookademic.bookademic.domain.entities.Role;
import com.bookademic.bookademic.domain.entities.User;
import com.bookademic.bookademic.domain.entities.UserCredential;
import com.bookademic.bookademic.domain.enums.Permission;
import com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound.PermissionNotFoundException;
import com.bookademic.bookademic.exceptions.domainExceptions.resourceNotFound.RoleNotFoundException;
import com.bookademic.bookademic.exceptions.domainExceptions.resourseConflict.ResourceConflictException;
import com.bookademic.bookademic.mappers.RoleMapper;
import com.bookademic.bookademic.repositories.RoleRepository;
import com.bookademic.bookademic.services.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService implements IService<Role> {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final UserService userService;

    @Autowired
    public RoleService(RoleRepository roleRepository,
                       RoleMapper roleMapper,
                       UserService userService) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userService = userService;
    }

    @Transactional
    private Role create(RoleCreateDTO roleCreateDTO) {
        Set<UserCredential> usersCredentials = new HashSet<>();
        Set<Permission> permissions = new HashSet<>();

        validateCodeUniqueness(roleCreateDTO.getCode());
        validateNameUniqueness(roleCreateDTO.getName());

        if (roleCreateDTO.getPermissions() != null) {
            for (Permission permission : roleCreateDTO.getPermissions()) {
                if (permission == null) {
                    throw new ResourceConflictException("Permission cannot be null.");
                }
                if (!EnumSet.allOf(Permission.class).contains(permission)) {
                    throw new PermissionNotFoundException("Invalid permission: " + permission);
                }
                permissions.add(permission);
            }
        }

        if(roleCreateDTO.getUsersIds() != null ) {
            for (Long userId : roleCreateDTO.getUsersIds()) {
                User foundUser = userService.findEntityById(userId);
                usersCredentials.add(foundUser.getUserCredential());
            }
        }

        Role role = roleMapper.toEntity(roleCreateDTO);
        role.setPermissions(new ArrayList<>(permissions));
        role.setUserCredentials(new ArrayList<>(usersCredentials));

        return roleRepository.save(role);
    }

    @Transactional(readOnly = true)
    public Role findEntityById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public RoleResponseAdminDTO findByIdAdminDTO(Long id) {
        Role role = findEntityById(id);
        return roleMapper.toResponseAdminDTO(role);
    }

    @Transactional(readOnly = true)
    public Role findByCode(String code) {
        return roleRepository.findByCode(code.toUpperCase())
                .orElseThrow(() -> new RoleNotFoundException("Role not found with code: " + code.toUpperCase()));
    }

    @Transactional(readOnly = true)
    public RoleResponseAdminDTO findByCodeAdminDTO(String code) {
        Role role = findByCode(code);
        return roleMapper.toResponseAdminDTO(role);
    }

    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<RoleResponseAdminDTO> findAllAdminDTO() {
        List<Role> roleResponseAdminDTOs = roleRepository.findAll();
        return roleResponseAdminDTOs.stream()
                .map(roleMapper::toResponseAdminDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<Role> searchByName(String partialName) {
        List<Role> roles = roleRepository.findByNameContainingIgnoreCase(partialName.toUpperCase());

        if( roles.isEmpty()) {
            throw new RoleNotFoundException("No roles found containing: " + partialName.toUpperCase());
        }

        return roles;
    }

    @Transactional(readOnly = true)
    public List<RoleResponseAdminDTO> searchByNameAdminDTO(String partialName) {
        List<Role> roles = searchByName(partialName);
        return roles.stream()
                .map(roleMapper::toResponseAdminDTO)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public Role update(RoleUpdateDTO roleUpdateDTO){
        Role existingRole;

        if(roleUpdateDTO.getId() != null && roleUpdateDTO.getExistingCode() != null) {
            existingRole = findEntityById(roleUpdateDTO.getId());
        } else if (roleUpdateDTO.getId() != null) {
            existingRole = findEntityById(roleUpdateDTO.getId());
        } else if (roleUpdateDTO.getExistingCode() != null) {
            existingRole = findByCode(roleUpdateDTO.getExistingCode().toUpperCase());
        } else {
            throw new ResourceConflictException("Either ID or code must be provided for update.");
        }

        if(roleUpdateDTO.getNewCode() != null) {
            validateCodeUniqueness(roleUpdateDTO.getNewCode(), existingRole.getId());
            existingRole.setCode(roleUpdateDTO.getNewCode().toUpperCase());
        }

        if(roleUpdateDTO.getName() != null) {
            validateNameUniqueness(roleUpdateDTO.getName());
            existingRole.setName(roleUpdateDTO.getName().toUpperCase());
        }

        if(roleUpdateDTO.getDescription() != null) {
            existingRole.setDescription(roleUpdateDTO.getDescription());
        }

        return roleRepository.save(existingRole);
    }

    @Transactional(rollbackFor = Exception.class)
    public Role deleteById(Long id) {
        Role role = findEntityById(id);
        isRoleAssignedToUser(role);
        isRoleAdmin(role);
        roleRepository.delete(role);
        return role;
    }

    private void validateCodeUniqueness(String code) {
        if (code == null || code.isBlank()) {
            return;
        }

        if (roleRepository.existsByCode(code.toUpperCase())) {
            throw new ResourceConflictException("Role with code '" + code.toUpperCase() + "' already exists.");
        }
    }

    private void validateCodeUniqueness(String code, Long currentId) {
        if (code == null || code.isBlank()) {
            return;
        }

        roleRepository.findByCode(code.toUpperCase()).ifPresent(existing -> {
            if (!existing.getId().equals(currentId)) {
                throw new ResourceConflictException("Role with code '" + code.toUpperCase() + "' already exists.");
            }
        });
    }

    private void validateNameUniqueness(String name) {

        if( name == null || name.isBlank()) {
            throw new ResourceConflictException("Role name cannot be null or blank.");
        }

        if(roleRepository.existsByName(name.toUpperCase())) {
            throw new ResourceConflictException("Role with name '" + name.toUpperCase() + "' already exists.");
        }
    }

    private void isRoleAssignedToUser(Role role) {
        if (role.getUserCredentials() != null && !role.getUserCredentials().isEmpty()) {
            throw new ResourceConflictException("Role cannot be deleted because it is assigned to one or more users.");
        }
    }

    private void isRoleAdmin(Role role) {
        if (role.getCode().equals("AD0001")) {
            throw new ResourceConflictException("Cannot delete the ADMIN role.");
        }
    }
}

