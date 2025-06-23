package com.bookademic.bookademic.dto.reservation.EventReservation;

import com.bookademic.bookademic.dto.event.EventResponseResumeDTO;
import com.bookademic.bookademic.dto.reservation.ReservationResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class EventReservationResponseDTO extends ReservationResponseDTO {

    @Schema(
        description = "Event associated with this reservation",
        example = "{\"id\": 3001, \"code\": \"RT0002\", \"name\": \"Book Fair 2023\"}"
    )
    private EventResponseResumeDTO event;
}
