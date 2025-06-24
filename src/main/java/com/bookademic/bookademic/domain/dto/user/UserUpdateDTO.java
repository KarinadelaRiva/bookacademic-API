package com.bookademic.bookademic.domain.dto.user;

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
public class UserUpdateDTO {

    @Schema(
            description = "Unique identifier of the user",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^\\d+$",
            message = "ID must be a positive integer"
    )
    private Long id;

    @Schema(
            description = "First name of the user",
            example = "John",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "First name must consist of letters only"
    )
    @Size(max = 30, message = "First name cannot exceed 50 characters")
    private String firstName;

    @Schema(
            description = "Last name of the user",
            example = "Doe",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "Last name must consist of letters only"
    )
    @Size(max = 30, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @Schema(
            description = "Email address of the user",
            example = "person@gmail.com",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Email must be a valid email address"
    )
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    private String email;

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
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Z]{2}\\d{4}$",
            message = "Role code must consist of two uppercase letters followed by four digits"
    )
    @Size(max = 6, message = "Role codes cannot exceed 6 characters each")
    private List<String> codeRoles;

}
