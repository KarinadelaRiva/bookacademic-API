package com.bookademic.bookademic.domain.dto.space;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SuperBuilder
public abstract class SpaceCreateDTO {

    @Schema(
            description = "Unique identifier for the space",
            example = "SP0123",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String code;

    @Schema(
            description = "Name of the space",
            example = "Conference Room A",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @NotNull(message = "Space name is required")
    private String name;

    @Schema(
            description = "Capacity of the space",
            example = "50",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Capacity must be a positive integer"
    )
    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @Schema(
            description = "Indicates if the lab has projector or not",
            example = "true",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasProjector = false;

    @Schema(
            description = "Indicates if the lab has TV or not",
            example = "true",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Boolean hasTV = false;

}
