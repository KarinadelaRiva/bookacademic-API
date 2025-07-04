package com.bookademic.bookademic.domain.dto.degreeProgram;

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
public class DegreeProgramCreateDTO {

    @Schema(
            description = "Degree program code",
            example = "CS1234",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String code;

    @Schema(
            description = "Name of the degree program. Must be unique for each program.",
            example = "Computer Science",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @NotNull(message = "Degree program name is required")
    @Pattern(
            regexp = "^[A-Za-z\\s]+$",
            message = "Name must consist of letters and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @Schema(
            description = "List of subject IDs to be associated with the degree program.",
            example = "[1, 2, 3]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<Long> subjectsIds;

    @Schema(
            description = "List of subject codes to be associated with the degree program.",
            example = "[\"CS1001\", \"MT2002\"]",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private List<String> subjectsCodes;
}
