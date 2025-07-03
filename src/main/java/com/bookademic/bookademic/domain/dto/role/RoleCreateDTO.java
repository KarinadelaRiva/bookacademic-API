package com.bookademic.bookademic.domain.dto.role;

import com.bookademic.bookademic.domain.enums.Permission;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleCreateDTO {

    @Schema(
            description = "Unique code for the role",
            example = "AD0001",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    @NotNull(message = "Role code is required")
    @Size(max = 6, message = "Role code cannot exceed 6 characters")
    private String code;

    @Schema(
            description = "Name of the role",
            example = "ADMIN",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z\\s]+$",
            message = "Role name must consist of letters or spaces only"
    )
    @NotNull(message = "Role name is required")
    @Size(max = 50, message = "Role name cannot exceed 50 characters")
    private String name;

    @Schema(
            description = "Description of the role",
            example = "Administrator with full access",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 255, message = "Role description cannot exceed 255 characters")
    private String description;

    @Schema(
            description = "List of permissions associated with the role",
            example = "[\"READ\", \"WRITE\", \"DELETE\"]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Permissions list cannot be null")
    @Size(min = 1, message = "At least one permission is required")
    private List<Permission> permissions;

    @Schema(
            description = "List of user IDs associated with the role",
            example = "[1, 2, 3]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<Long> usersIds;
}
