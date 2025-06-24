package com.bookademic.bookademic.domain.dto.request.EventRequest;

import com.bookademic.bookademic.domain.dto.event.EventResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.request.RequestResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class EventRequestResponseDTO extends RequestResponseDTO {

    @Schema(
        description = "Event associated with this request",
        example = "{\"id\": 3001, \"code\": \"RT0002\", \"name\": \"Book Fair 2023\"}"
    )
    private EventResponseResumeDTO event;
}
