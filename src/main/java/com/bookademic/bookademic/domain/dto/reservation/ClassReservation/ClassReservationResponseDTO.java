package com.bookademic.bookademic.domain.dto.reservation.ClassReservation;

import com.bookademic.bookademic.domain.dto.classGroup.ClassGroupResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClassReservationResponseDTO extends ReservationResponseDTO {

    @Schema(
            description = "Class group associated with this reservation",
            example = "{\"id\": 1001, \"code\": \"CG001\", \"name\": \"Advanced Mathematics\"}"
    )
    private ClassGroupResponseResumeDTO classGroup;
}
