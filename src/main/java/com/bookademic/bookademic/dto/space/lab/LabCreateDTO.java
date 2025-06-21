package com.bookademic.bookademic.dto.space.lab;

import com.bookademic.bookademic.dto.space.SpaceCreateDTO;
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
public class LabCreateDTO extends SpaceCreateDTO {

    @Schema(
        description = "Number of computers in the lab",
        example = "30",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
        regexp = "^[0-9]+$",
        message = "Number of computers must be a non-negative integer"
    )
    private Integer numberOfComputers = 0;

    @Schema(
        description = "Indicates if the lab has special equipment or not",
        example = "true",
        requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasSpecialEquipment = false;


}
