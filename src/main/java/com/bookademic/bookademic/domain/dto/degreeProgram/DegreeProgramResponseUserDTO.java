package com.bookademic.bookademic.domain.dto.degreeProgram;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DegreeProgramResponseUserDTO {

    @Schema(
            description = "Unique identifier of the degree program",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the degree program",
            example = "CS1234"
    )
    private String code;

    @Schema(
            description = "Name of the degree program",
            example = "Computer Science"
    )
    private String name;

    @Schema(
            description = "List of subjects associated with the degree program",
            example = "[\"MT1001 - Mathematics I\", \"PR1516 - Programming I\"]"
    )
    private List<String> subjects;
}
