package com.bookademic.bookademic.dto.request.EventRequest;

import com.bookademic.bookademic.dto.request.RequestCreateDTO;
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
public class EventRequestCreateDTO extends RequestCreateDTO {

    @Schema(
        description = "ID of the event associated with this request",
        example = "3001",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    @Pattern(
            regexp = "\\d+",
            message = "Event ID must be a positive number"
    )
    @NotNull(message = "Event ID is required")
    private Long eventId;
}
