package com.bookademic.bookademic.domain.dto.request.ClassRequest;

import com.bookademic.bookademic.domain.dto.request.RequestCreateDTO;
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
public class ClassRequestCreateDTO extends RequestCreateDTO {

    @Schema(
        description = "ID of the class group associated with this request",
        example = "2001",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Class group ID must be a positive number"
    )
    @NotNull(message = "Class group ID is required")
    private Long classGroupId;
}
