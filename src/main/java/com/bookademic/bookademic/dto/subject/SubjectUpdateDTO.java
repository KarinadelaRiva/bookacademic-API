package com.bookademic.bookademic.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SubjectUpdateDTO {

    @Schema(
            description = "ID of the subject to update (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Long id;

    @Schema(
            description = "Code of the subject to update (alternative to ID)",
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
            example = "Computer Science 1"
            , requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
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

}
