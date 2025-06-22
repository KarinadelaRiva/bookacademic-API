package com.bookademic.bookademic.dto.reservation.EventReservation;

import com.bookademic.bookademic.dto.reservation.ReservationCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class EventReservationCreateDTO extends ReservationCreateDTO {

    @Schema(
            description = "ID of the event associated with this reservation",
            example = "3001",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Event ID must be a positive number"
    )
    @NotNull(message = "Event ID is required")
    private Long eventId;
}
