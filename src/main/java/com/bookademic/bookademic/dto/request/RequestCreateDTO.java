package com.bookademic.bookademic.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class RequestCreateDTO {

    @Schema(
            description = "ID of the original reservation associated with this request (if applicable)",
            example = "1001",
            nullable = true,
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Original reservation ID must be a positive number"
    )
    private Long originalReservationId;

    @Schema(
            description = "ID of the space being requested",
            example = "15",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Requested space ID must be a positive number"
    )
    @NotNull(message = "Requested space ID is required")
    private Long requestedSpaceId;

    @Schema(
            description = "Start date of the request",
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
            description = "End date of the request",
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
            description = "Day of the week for the request",
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
            description = "Start time of the request",
            example = "08:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{2}:\\d{2}",
            message = "Start time must be in the format HH:MM"
    )
    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @Schema(
            description = "End time of the request",
            example = "10:00",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d{2}:\\d{2}",
            message = "End time must be in the format HH:MM"
    )
    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @Schema(
            description = "Comment from the requester",
            example = "Please consider this request for additional space.",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[\\w\\s.,!?-]{0,500}$",
            message = "Requester comment must be up to 500 characters long and can include letters, numbers, spaces, and punctuation."
    )
    private String requesterComment;
}
