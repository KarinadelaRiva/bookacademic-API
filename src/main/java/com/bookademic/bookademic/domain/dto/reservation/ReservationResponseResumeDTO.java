package com.bookademic.bookademic.domain.dto.reservation;

import com.bookademic.bookademic.domain.dto.space.SpaceResponseResumeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationResponseResumeDTO {

    @Schema(
            description = "Unique identifier of the reservation",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Start date of the reservation",
            example = "2025-06-15"
    )
    private LocalDate startDate;

    @Schema(
            description = "End date of the reservation",
            example = "2025-06-20"
    )
    private LocalDate endDate;

    @Schema(
            description = "Day of the week for the reservation",
            example = "MONDAY"
    )
    private DayOfWeek dayOfWeek;

    @Schema(
            description = "Start time of the reservation",
            example = "09:00"
    )
    private LocalTime startTime;

    @Schema(
            description = "End time of the reservation",
            example = "11:00"
    )
    private LocalTime endTime;

    @Schema(
            description = "Space associated with the reservation",
            example = "{ \"id\": 15, \"code\": \"MD0001\" ,\"name\": \"Conference Room A\"}"
    )
    private SpaceResponseResumeDTO space;

    @Schema(
            description = "Name of the class or event associated with the reservation"
    )
    private String classOrEventName;

    @Schema(
            description = "Name of the user responsible for the class or event"
    )
    private String classOrEventResponsibleName;
}