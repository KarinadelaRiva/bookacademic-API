package com.bookademic.bookademic.domain.dto.userCredential;

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
public class UserCredentialCreateDTO {

    @Schema(
            description = "Username for the user",
            example = "johndoe-123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[a-zA-Z0-9._-]{3,30}$",
            message = "Username must be 3-30 characters long and can contain letters, numbers, dots, underscores, and hyphens"
    )
    @NotNull(message = "Username is required")
    @Size(min = 3 ,max = 30, message = "Username cannot exceed 30 characters")
    private String username;

    @Schema(
            description = "Password for the user",
            example = "password*123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters long")
    private String password;

    @Schema(
            description = "Confirmation of the password",
            example = "password*123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @NotNull(message = "Password is required")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters long")
    private String confirmPassword;

    @Schema(
            description = "List of role code to be associated with the user",
            example = "[\"DR1234\", \"FR2345\"]",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Role codes are required")
    @Size(max = 6, message = "Role codes cannot exceed 6 characters each")
    private List<
            @Pattern(
                    regexp = "^[A-Z]{2}\\d{4}$",
                    message = "Role code must consist of two uppercase letters followed by four digits"
            )
            String> codeRoles;
}
