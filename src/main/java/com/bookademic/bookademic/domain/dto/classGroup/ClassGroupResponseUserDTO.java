package com.bookademic.bookademic.domain.dto.classGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassGroupResponseUserDTO {
    @Schema(
            description = "Unique identifier of the class group",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the class group",
            example = "CS1234"
    )
    private String code;

    @Schema(
            description = "Name of the class group",
            example = "Group A"
    )
    private String name;

    @Schema(
            description = "Indicates count of students in the class group",
            example = "30"
    )
    private Integer studentCount;

    @Schema(
            description = "Code of the subject associated with the class group",
            example = "CS101"
    )
    private String subjectCode;

    @Schema(
            description = "Name of the subject associated with the class group",
            example = "Computer Science 101"
    )
    private String subjectName;

    @Schema(
            description = "Name of the professor who teaches the class group",
            example = "Dr. John Doe"
    )
    private String professorName;
}
