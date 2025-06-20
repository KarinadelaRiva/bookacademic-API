package com.bookademic.bookademic.dto.classGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClassGroupResponseResumeDTO {
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
}
