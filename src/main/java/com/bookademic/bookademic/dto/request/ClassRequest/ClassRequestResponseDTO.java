package com.bookademic.bookademic.dto.request.ClassRequest;

import com.bookademic.bookademic.dto.classGroup.ClassGroupResponseResumeDTO;
import com.bookademic.bookademic.dto.request.RequestResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClassRequestResponseDTO extends RequestResponseDTO {

    @Schema(
            description = "Class group associated with this request",
            example = "{ \"id\": 1, \"code\": \"AD0001\", \"name\": \"Math 101\" }"
    )
    private ClassGroupResponseResumeDTO classGroup;
}
