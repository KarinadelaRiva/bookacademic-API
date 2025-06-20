package com.bookademic.bookademic.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SubjectResponseUserDTO {

    @Schema(
            description = "Unique identifier of the subject",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the subject",
            example = "CS1234"
    )
    private String code;

    @Schema(
            description = "Name of the subject",
            example = "Programming Fundamentals"
    )
    private String name;

    @Schema(
            description = "Indicates if the subject requires a lab",
            example = "true"
    )
    private Boolean requiresLab;

    @Schema(
            description = "Indicates if the subject requires a workshop",
            example = "false"
    )
    private Boolean requiresWorkshop;

    @Schema(
            description = "List of degree programs associated with the subject",
            example = "[\"CS1001 - Computer Science\", \"IT1256 - Information Technology\"]"
    )
    private List<String> degreePrograms;
}
