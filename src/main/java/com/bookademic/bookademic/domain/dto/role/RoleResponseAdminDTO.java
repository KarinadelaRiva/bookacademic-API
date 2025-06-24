package com.bookademic.bookademic.domain.dto.role;

import com.bookademic.bookademic.domain.enums.Permission;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleResponseAdminDTO {

    @Schema(
            description = "Unique identifier of the role to be updated (alternative to code)",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Unique code for the role to be updated (alternative to ID)",
            example = "AD0001"
    )
    private String code;

    @Schema(
            description = "Name of the role",
            example = "ADMIN"
    )
    private String name;

    @Schema(
            description = "Description of the role",
            example = "Administrator with full access"
    )
    private String description;

    @Schema(
            description = "List of permissions associated with the role",
            example = "[\"READ\", \"WRITE\", \"DELETE\"]"
    )
    private List<Permission> permissions;

}
