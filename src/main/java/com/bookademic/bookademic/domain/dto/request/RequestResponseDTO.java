package com.bookademic.bookademic.domain.dto.request;

import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.space.SpaceResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.user.UserResponseResumeDTO;
import com.bookademic.bookademic.domain.enums.RequestState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class RequestResponseDTO {

    @Schema(
            description = "Unique identifier of the request",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Creation date and time of the request",
            example = "2025-06-15T08:00:00"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Current state of the request",
            example = "PENDING"
    )
    private RequestState state;

    @Schema(
            description = "User who made the request"
    )
    private UserResponseResumeDTO requester;

    @Schema(
            description = "Original reservation associated with the request, if applicable"
    )
    private ReservationResponseResumeDTO originalReservation;

    @Schema(
            description = "Space associated with the request"
    )
    private SpaceResponseResumeDTO space;

    @Schema(
            description = "Start date requested for the reservation",
            example = "2025-06-15"
    )
    private LocalDate startDate;

    @Schema(
            description = "End date requested for the reservation",
            example = "2025-06-20"
    )
    private LocalDate endDate;

    @Schema(
            description = "Day of the week for the reservation",
            example = "MONDAY"
    )
    private DayOfWeek dayOfWeek;

    @Schema(
            description = "Start time requested for the reservation",
            example = "08:00"
    )
    private LocalTime startTime;

    @Schema(
            description = "End time requested for the reservation",
            example = "10:00"
    )
    private LocalTime endTime;

    @Schema(
            description = "Comment from the requester",
            example = "Please consider this request for the upcoming week."
    )
    private String requesterComment;

    @Schema(
            description = "Comment from the admin regarding the request",
            example = "Request approved for the requested dates."
    )
    private String adminComment;
}
