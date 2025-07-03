package com.bookademic.bookademic.domain.dto.degreeProgram;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DegreeProgramUpdateDTO {

    @Schema(
            description = "ID of the degree program to update (alternative to code)",
            example = "1",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    private Long id;

    @Schema(
            description = "Code of the degree program to update (alternative to ID)",
            example = "CS1234",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String existingCode;

    @Schema(
            description = "New code for the degree program",
            example = "CS1234",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED
    )
    @Pattern(
            regexp = "^[A-Za-z]{2}\\d{4}$",
            message = "Code must consist of two letters followed by four digits"
    )
    private String newCode;

    @Schema(
            description = "New name of the degree program",
            example = "Computer Science"
    )
    @Pattern(
            regexp = "^[A-Za-z\\s]+$",
            message = "Name must consist of letters and spaces only"
    )
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;
}
