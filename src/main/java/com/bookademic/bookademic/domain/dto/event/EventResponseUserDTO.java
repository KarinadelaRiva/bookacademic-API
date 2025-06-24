package com.bookademic.bookademic.domain.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventResponseUserDTO {
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

    @Schema(
            description = "Description of the event",
            example = "A grand event showcasing various books and authors."
    )
    private String description;

    @Schema(
            description = "Name of the user organizer associated with the event",
            example = "John Doe"
    )
    private String organizerName;

    @Schema(
            description = "Maximum number of participants",
            example = "50"
    )
    private Integer maxParticipants;
}
