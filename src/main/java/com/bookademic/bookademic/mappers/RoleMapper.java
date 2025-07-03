package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.role.RoleCreateDTO;
import com.bookademic.bookademic.domain.dto.role.RoleResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.role.RoleResponseResumeDTO;
import com.bookademic.bookademic.domain.entities.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponseAdminDTO toResponseAdminDTO(Role entity) {
        return RoleResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .permissions(entity.getPermissions())
                .build();
    }

    public RoleResponseResumeDTO toResumeDTO(Role entity) {
        return RoleResponseResumeDTO.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public Role toEntity(RoleCreateDTO dto) {
        return Role.builder()
                .code(dto.getCode().toUpperCase())
                .name(dto.getName().toUpperCase())
                .description(dto.getDescription())
                .build();
    }
}
