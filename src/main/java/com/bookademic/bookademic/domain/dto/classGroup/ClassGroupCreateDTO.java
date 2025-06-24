package com.bookademic.bookademic.domain.dto.classGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassGroupCreateDTO {

    @Schema(
            description = "Class group code",
            example = "CG1234",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String code;

    @Schema(
            description = "Name of the class group.",
            example = "Advanced Mathematics",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    @NotNull(message = "Class group name is required")
    private String name;

    @Schema(
            description = "Number of students in the class group.",
            example = "30",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^\\d+$",
            message = "Student count must be a numeric value"
    )
    @NotNull(message = "Student count is required")
    private Integer studentCount;

    @Schema(
            description = "ID of the professor who teaches the class group.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Professor ID must be a numeric positive value"
    )
    @NotNull(message = "Professor ID is required")
    private Long professorId;

    @Schema(
            description = "ID of the subject associated with the class group.",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Subject ID must be a numeric positive value"
    )
    @NotNull(message = "Subject ID is required")
    private Long subjectId;
}
