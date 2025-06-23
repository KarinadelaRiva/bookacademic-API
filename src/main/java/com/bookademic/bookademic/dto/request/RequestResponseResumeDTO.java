package com.bookademic.bookademic.dto.request;

import com.bookademic.bookademic.enums.RequestState;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RequestResponseResumeDTO {

    @Schema(
            description = "Unique identifier of the request",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Creation date and time of the request",
            example = "2025-06-15T08:00:00"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Current state of the request",
            example = "PENDING"
    )
    private RequestState state;

    @Schema(
            description = "Type of request, e.g., 'CLASS_REQUEST', 'EVENT_REQUEST'"
    )
    private String typeRequest;

    @Schema(
            description = "Comment provided by the admin when processing the request"
    )
    private String adminComment;
}
