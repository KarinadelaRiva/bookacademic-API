package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.role.RoleCreateDTO;
import com.bookademic.bookademic.dto.role.RoleResponseAdminDTO;
import com.bookademic.bookademic.dto.role.RoleResponseResumeDTO;
import com.bookademic.bookademic.entities.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleResponseAdminDTO toAdminDTO(Role entity) {
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
                .code(dto.getCode())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}
