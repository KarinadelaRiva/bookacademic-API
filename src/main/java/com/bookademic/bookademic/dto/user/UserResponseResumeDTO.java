package com.bookademic.bookademic.dto.user;

import com.bookademic.bookademic.dto.classGroup.ClassGroupResponseResumeDTO;
import com.bookademic.bookademic.dto.event.EventResponseResumeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponseResumeDTO {

    @Schema(
            description = "Unique identifier of the user",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "First name of the user",
            example = "John"
    )
    private String firstName;

    @Schema(
            description = "Last name of the user",
            example = "Doe"
    )
    private String lastName;

    @Schema(
            description = "Email address of the user",
            example = "person@gmail.com"
    )
    private String email;

}
