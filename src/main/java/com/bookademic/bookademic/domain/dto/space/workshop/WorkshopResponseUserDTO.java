package com.bookademic.bookademic.domain.dto.space.workshop;

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
public class WorkshopResponseUserDTO extends SpaceResponseUserDTO {

    @Schema(
        description = "Number of workstations in the workshop",
        example = "10"
    )
    private Integer numberOfWorkstations;

    @Schema(
        description = "Indicates if the workshop has tools or not",
        example = "true"
    )
    private Boolean hasTools;

}
