package com.bookademic.bookademic.domain.dto.schedule;

import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ScheduleBySpace {

    @Schema(
        description = "Name of the physical space (classroom, laboratory, etc.)",
        example = "Room 101"
    )
    private String spaceName;

    @Schema(
        description = "List of reservations associated with the space"
    )
    private List<ReservationResponseDTO> reservations;
}
