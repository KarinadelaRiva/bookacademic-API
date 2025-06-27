package com.bookademic.bookademic.domain.dto;

import com.bookademic.bookademic.domain.dto.user.UserCreateDTO;
import com.bookademic.bookademic.domain.dto.userCredential.UserCredentialCreateDTO;
import jakarta.validation.Valid;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserRegistrationDTO {
    @Valid
    private UserCreateDTO user;

    @Valid
    private UserCredentialCreateDTO credentials;
}
