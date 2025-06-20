package com.bookademic.bookademic.dto.subject;

import com.bookademic.bookademic.dto.degreeProgram.DegreeProgramResponseResumeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SubjectResponseAdminDTO {

    @Schema(
            description = "Unique identifier of the subject",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Code of the subject",
            example = "CS1234"
    )
    private String code;

    @Schema(
            description = "Name of the subject",
            example = "Programming Fundamentals"
    )
    private String name;

    @Schema(
            description = "Indicates if the subject requires a lab",
            example = "true"
    )
    private Boolean requiresLab;

    @Schema(
            description = "Indicates if the subject requires a workshop",
            example = "false"
    )
    private Boolean requiresWorkshop;

    @Schema(
            description = "Indicates if the subject is active",
            example = "true"
    )
    private String isActive;

    @Schema(
            description = "List of degree programs associated with the subject"
    )
    private List<DegreeProgramResponseResumeDTO> degreePrograms;


}
