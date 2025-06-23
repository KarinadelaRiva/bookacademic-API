package com.bookademic.bookademic.dto.role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleUpdateDTO {

    @Schema(
            description = "Unique identifier of the role to be updated (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^\\d+$",
            message = "ID must be a positive integer"
    )
    private Long id;

    @Schema(
            description = "Unique code for the role to be updated (alternative to ID)",
            example = "AD0001",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    @Size(max = 6, message = "Role code cannot exceed 6 characters")
    private String code;

    @Schema(
            description = "Name of the role",
            example = "ADMIN",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z\\s]+$",
            message = "Role name must consist of letters or spaces only"
    )
    @Size(max = 50, message = "Role name cannot exceed 50 characters")
    private String name;

    @Schema(
            description = "Description of the role",
            example = "Administrator with full access",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Size(max = 255, message = "Role description cannot exceed 255 characters")
    private String description;
}
