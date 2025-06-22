package com.bookademic.bookademic.dto.reservation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationUpdateDTO {

    @Schema(
            description = "Unique identifier of the reservation",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Reservation ID must be a positive number"
    )
    @NotNull(message = "Reservation ID is required")
    private Long id;

    @Schema(
            description = "Start date of the reservation",
            example = "2025-06-15",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "Start date must be in the format YYYY-MM-DD"
    )
    @FutureOrPresent(message = "Start date must be today or in the future")
    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @Schema(
            description = "End date of the reservation",
            example = "2025-06-20",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{4}-\\d{2}-\\d{2}",
            message = "End date must be in the format YYYY-MM-DD"
    )
    @FutureOrPresent(message = "End date must be today or in the future")
    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @Schema(
            description = "Day of the week for the reservation",
            example = "MONDAY",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY",
            message = "Day of the week must be one of: MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY"
    )
    @NotNull(message = "Day of the week is required")
    private DayOfWeek dayOfWeek;

    @Schema(
            description = "Start time of the reservation",
            example = "09:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{2}:\\d{2}",
            message = "Start time must be in the format HH:MM"
    )
    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @Schema(
            description = "End time of the reservation",
            example = "11:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{2}:\\d{2}",
            message = "End time must be in the format HH:MM"
    )
    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @Schema(
            description = "ID of the space to be reserved",
            example = "1001",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Space ID must be a positive number"
    )
    @NotNull(message = "Space ID is required")
    private Long spaceId;

    @Schema(
            description = "ID of the requester making the reservation",
            example = "2001",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Requester ID must be a positive number"
    )
    @NotNull(message = "Requester ID is required")
    private Long requesterId;
}