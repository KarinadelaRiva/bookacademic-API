package com.bookademic.bookademic.domain.dto.reservation.ClassReservation;

import com.bookademic.bookademic.domain.dto.reservation.ReservationCreateDTO;
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
public class ClassReservationCreateDTO extends ReservationCreateDTO {

    @Schema(
            description = "ID of the class group associated with this reservation",
            example = "1001",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Class group ID must be a positive number"
    )
    @NotNull(message = "Class group ID is required")
    private Long classGroupId;
}
