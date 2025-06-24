package com.bookademic.bookademic.domain.dto.classGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassGroupUpdateDTO {

    @Schema(
            description = "ID of the class group to update (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Long id;

    @Schema(
            description = "Code of the class group to update (alternative to ID)",
            example = "CS1234",
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
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @Schema(
            description = "Indicantes count of students in the class group.",
            example = "30",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Student count must be a numeric value"
    )
    private Integer studentCount;

    @Schema(
            description = "ID of the professor who teaches the class group.",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Professor ID must be a numeric value"
    )
    private Long professorId;

}
