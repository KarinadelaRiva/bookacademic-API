package com.bookademic.bookademic.domain.dto.space;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public abstract class SpaceUpdateDTO {

    @Schema(
            description = "Unique identifier for the space (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "ID must be a positive integer"
    )
    private Long id;

    @Schema(
            description = "Unique identifier for the space (alternative to ID)",
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
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z0-9\\s]+$",
            message = "Name must consist of letters, numbers and spaces only"
    )
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Schema(
            description = "Capacity of the space",
            example = "50",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[1-9]\\d*$",
            message = "Capacity must be a positive integer"
    )
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
