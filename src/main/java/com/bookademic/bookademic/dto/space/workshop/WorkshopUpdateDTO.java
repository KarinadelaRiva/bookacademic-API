package com.bookademic.bookademic.dto.space.workshop;

import com.bookademic.bookademic.dto.space.SpaceUpdateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class WorkshopUpdateDTO extends SpaceUpdateDTO {

    @Schema(
        description = "Number of workstations in the workshop",
        example = "10",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
        regexp = "^[0-9]+$",
        message = "Number of workstations must be a non-negative integer"
    )
    private Integer numberOfWorkstations = 0;

    @Schema(
        description = "Indicates if the workshop has tools or not",
        example = "true",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasTools = false;

}
