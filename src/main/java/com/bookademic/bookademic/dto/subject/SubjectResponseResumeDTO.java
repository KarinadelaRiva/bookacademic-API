package com.bookademic.bookademic.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SubjectResponseResumeDTO {

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

}
