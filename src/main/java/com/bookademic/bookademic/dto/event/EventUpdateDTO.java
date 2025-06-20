package com.bookademic.bookademic.dto.event;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EventUpdateDTO {

    @Schema(
            description = "Unique identifier of the event (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private Long id;

    @Schema(
            description = "Unique code for the event (alternative to ID)",
            example = "EV2345",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String code;

    @Schema(
            description = "Name of the event",
            example = "Book Fair 2023",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Schema(
            description = "Description of the event",
            example = "An annual book fair showcasing various genres and authors.",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Schema(
            description = "Maximum number of participants allowed for the event",
            example = "100",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Maximum participants must be a positive integer"
    )
    private Integer maxParticipants;

    @Schema(
            description = "ID of the user organizer associated with the event.",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Organizer ID must be a numeric positive value"
    )
    private Long organizerId;
}
