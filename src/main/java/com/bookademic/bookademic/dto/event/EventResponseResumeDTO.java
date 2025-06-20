package com.bookademic.bookademic.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventResponseResumeDTO {

    @Schema(
        description = "Unique identifier of the event",
        example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the event",
            example = "EV1234"
    )
    private String code;

    @Schema(
            description = "Name of the event",
            example = "Annual Book Fair"
    )
    private String name;
}
