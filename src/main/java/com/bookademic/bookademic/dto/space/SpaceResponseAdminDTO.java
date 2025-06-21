package com.bookademic.bookademic.dto.space;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class SpaceResponseAdminDTO {

    @Schema(
            description = "Unique identifier of the space",
            example = "12345"
    )
    private String id;

    @Schema(
            description = "Code of the space",
            example = "SPC-001"
    )
    private String code;

    @Schema(
            description = "Type of the space",
            example = "Lab"
    )
    private String type;

    @Schema(
            description = "Name of the space",
            example = "Computer Lab 1"
    )
    private String name;

    @Schema(
            description = "Indicates if the space is active",
            example = "true"
    )
    private String isActive;

    @Schema(
            description = "Capacity of the space",
            example = "30"
    )
    private Integer capacity;

    @Schema(
            description = "Indicates if the space has projector",
            example = "true"
    )
    private String hasProjector;

    @Schema(
            description = "Indicates if the space has TV",
            example = "false"
    )
    private String hasTV;
}
