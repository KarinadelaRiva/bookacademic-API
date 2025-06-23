package com.bookademic.bookademic.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventResponseAdminDTO {

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
            description = "Email of the user organizer associated with the event",
            example = "example@dominio.com"
    )
    private String organizerEmail;

    @Schema(
            description = "Maximum number of participants",
            example = "50"
    )
    private Integer maxParticipants;

    @Schema(
            description = "Indicates if the event is active",
            example = "true"
    )
    private Boolean isActive;
}
