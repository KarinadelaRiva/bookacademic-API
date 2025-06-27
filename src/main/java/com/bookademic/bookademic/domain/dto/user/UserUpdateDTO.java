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

}
