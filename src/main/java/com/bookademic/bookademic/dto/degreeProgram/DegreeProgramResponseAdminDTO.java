package com.bookademic.bookademic.dto.degreeProgram;

import com.bookademic.bookademic.dto.subject.SubjectResponseResumeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DegreeProgramResponseAdminDTO {

    @Schema(
            description = "Unique identifier of the degree program",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the degree program",
            example = "CS1234"
    )
    private String code;

    @Schema(
            description = "Name of the degree program",
            example = "Computer Science"
    )
    private String name;

    @Schema(
            description = "Indicates whether the degree program is active",
            example = "true"
    )
    private Boolean isActive;

    @Schema(
            description = "List of subjects associated with the degree program"
    )
    private List<SubjectResponseResumeDTO> subjects;
}
