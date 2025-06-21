package com.bookademic.bookademic.dto.space.workshop;

import com.bookademic.bookademic.dto.space.SpaceCreateDTO;
import com.bookademic.bookademic.dto.space.SpaceResponseAdminDTO;
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
public class WorkshopResponseAdminDTO extends SpaceResponseAdminDTO {

    @Schema(
        description = "Number of workstations in the workshop",
        example = "10"
    )
    private Integer numberOfWorkstations;

    @Schema(
        description = "Indicates if the workshop has tools or not",
        example = "true"
    )
    private String hasTools;

}
