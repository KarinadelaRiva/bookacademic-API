package com.bookademic.bookademic.dto.subject;

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
public class SubjectCreateDTO {

    @Schema(
            description = "Subject code",
            example = "CS1234",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String code;

    @Schema(
            description = "New name of the subject",
            example = "Computer Science 1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    @NotNull(message = "Subject name is required")
    private String name;

    @Schema(
            description = "Indicates if the subject requires a lab.",
            example = "true",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean requiresLab;

    @Schema(
            description = "Indicates if the subject requires a workshop.",
            example = "false",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean requiresWorkshop;

    @Schema(
            description = "List of degree program IDs to be associated with the subject",
            example = "[1, 2, 3]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<Long> degreeProgramIds;

    @Schema(
            description = "List of degree program codes to be associated with the subject.",
            example = "[\"CS1234\", \"EN5678\"]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<String> degreeProgramCodes;
}
