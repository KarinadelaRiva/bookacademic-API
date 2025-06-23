package com.bookademic.bookademic.dto.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleResponseResumeDTO {

    @Schema(
            description = "Unique code for the role to be updated (alternative to ID)",
            example = "AD0001"
    )
    private String code;

    @Schema(
            description = "Name of the role",
            example = "ADMIN"
    )
    private String name;

}
