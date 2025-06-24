package com.bookademic.bookademic.domain.dto.user;

import com.bookademic.bookademic.domain.dto.classGroup.ClassGroupResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.event.EventResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.request.RequestResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.role.RoleResponseResumeDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponseAdminDTO {

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

    @Schema(
            description = "Indicates if the user is active",
            example = "true"
    )
    private Boolean isActive;

    @Schema(
            description = "List of roles assigned to the user",
            example = "[{\"code\": \"ADMIN\", \"name\": \"Admin\"}]"
    )
    private List<RoleResponseResumeDTO> roles;

    @Schema(
            description = "List of class groups associated with the user",
            example = "[{\"id\": 1, \"code\": \"AD0001\", \"name\": \"Math 101\"}]"
    )
    private List<ClassGroupResponseResumeDTO> classGroups;

    @Schema(
            description = "List of events associated with the user",
            example = "[{\"id\": 1, \"code\": \"AD0001\", \"name\": \"Event 1\"}]"
    )
    private List<EventResponseResumeDTO> events;

    @Schema(
            description = "List of requests made by the user"
    )
    private List<RequestResponseResumeDTO> requests;

    @Schema(description = "List of reservations associated with the user")
    private List<ReservationResponseResumeDTO> reservations;





}
