package com.bookademic.bookademic.domain.dto.space.lab;

import com.bookademic.bookademic.domain.dto.space.SpaceResponseUserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class LabResponseUserDTO extends SpaceResponseUserDTO {

    @Schema(
        description = "Number of computers in the lab",
        example = "30"
    )
    private Integer numberOfComputers;

    @Schema(
        description = "Indicates if the lab has special equipment or not",
        example = "true"
    )
    private Boolean hasSpecialEquipment;


}
