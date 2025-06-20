package com.bookademic.bookademic.dto.degreeProgram;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DegreeProgramResponseResumeDTO {
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
}
