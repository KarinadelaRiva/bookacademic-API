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
public class UserCredentialUpdateDTO {

    @Schema(
            description = "New username for the user",
            example = "new_username123",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[a-zA-Z0-9._-]{3,30}$",
            message = "Username must be 3-30 characters long and can contain letters, numbers, dots, underscores, and hyphens"
    )
    @Size(min = 3 ,max = 30, message = "Username cannot exceed 30 characters")
    private String newUsername;

    @Schema(
            description = "Current password (required to authorize credential changes)",
            example = "OldPassword*123",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Current password is required")
    private String currentPassword;

    @Schema(
            description = "New password for the user",
            example = "NewPassword*123"
    )
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters long")
    private String newPassword;

    @Schema(
            description = "Confirmation of the new password",
            example = "NewPassword*123"
    )
    private String confirmNewPassword;
}
