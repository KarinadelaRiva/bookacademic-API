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
public class UserCreateDTO {

    @Schema(
            description = "First name of the user",
            example = "John",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "First name must consist of letters only"
    )
    @NotNull(message = "First name is required")
    @Size(max = 30, message = "First name cannot exceed 50 characters")
    private String firstName;

    @Schema(
            description = "Last name of the user",
            example = "Doe",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]+$",
            message = "Last name must consist of letters only"
    )
    @NotNull(message = "Last name is required")
    @Size(max = 30, message = "Last name cannot exceed 50 characters")
    private String lastName;

    @Schema(
            description = "Email address of the user",
            example = "person@gmail.com",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Email must be a valid email address"
    )
    @NotNull(message = "Email is required")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    private String email;

}
