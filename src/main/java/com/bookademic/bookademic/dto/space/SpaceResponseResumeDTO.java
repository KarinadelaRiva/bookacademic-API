package com.bookademic.bookademic.dto.space;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public abstract class SpaceResponseResumeDTO {

    @Schema(
            description = "Unique identifier of the space",
            example = "12345"
    )
    private Long id;

    @Schema(
            description = "Code of the space",
            example = "SPC-001"
    )
    private String code;

    @Schema(
            description = "Type of the space",
            example = "Lab"
    )
    private String type;

    @Schema(
            description = "Name of the space",
            example = "Computer Lab 1"
    )
    private String name;
}
