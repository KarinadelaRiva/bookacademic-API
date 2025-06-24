package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.user.UserCreateDTO;
import com.bookademic.bookademic.domain.dto.user.UserResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.user.UserResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.user.UserResponseUserDTO;
import com.bookademic.bookademic.domain.entities.Role;
import com.bookademic.bookademic.domain.entities.User;
import com.bookademic.bookademic.domain.entities.UserCredential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    private final RoleMapper roleMapper;
    private final ClassGroupMapper classGroupMapper;
    private final EventMapper eventMapper;
    private final RequestMapper requestMapper;
    private final ReservationMapper reservationMapper;

    @Autowired
    public UserMapper(RoleMapper roleMapper,
                      ClassGroupMapper classGroupMapper,
                      EventMapper eventMapper,
                      @Lazy RequestMapper requestMapper,
                      @Lazy ReservationMapper reservationMapper) {
        this.roleMapper = roleMapper;
        this.classGroupMapper = classGroupMapper;
        this.eventMapper = eventMapper;
        this.requestMapper = requestMapper;
        this.reservationMapper = reservationMapper;
    }

    public UserResponseAdminDTO toResponseAdminDTO(User entity) {
        return UserResponseAdminDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .isActive(entity.getActive())
                .roles(entity.getRoles().stream()
                        .map(roleMapper::toResumeDTO)
                        .toList())
                .classGroups(entity.getClassGroups().stream()
                        .map(classGroupMapper::toResumeDTO)
                        .toList())
                .events(entity.getEvents().stream()
                        .map(eventMapper::toResumeDTO)
                        .toList())
                .requests(entity.getRequests().stream()
                        .map(requestMapper::toResumeDTO)
                        .toList())
                .reservations(entity.getReservations().stream()
                        .map(reservationMapper::toResumeDTO)
                        .toList())
                .build();
    }

    public UserResponseUserDTO toResponseUserDTO(User entity) {
        return UserResponseUserDTO.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .username(entity.getUserCredential().getUsername())
                .roles(entity.getRoles().stream()
                        .map(roleMapper::toResumeDTO)
                        .toList())
                .classGroups(entity.getClassGroups().stream()
                        .map(classGroupMapper::toResumeDTO)
                        .toList())
                .events(entity.getEvents().stream()
                        .map(eventMapper::toResumeDTO)
                        .toList())
                .requests(entity.getRequests().stream()
                        .map(requestMapper::toResumeDTO)
                        .toList())
                .reservations(entity.getReservations().stream()
                        .map(reservationMapper::toResumeDTO)
                        .toList())
                .build();
    }

    public UserResponseResumeDTO toResumeDTO(User entity) {
        return UserResponseResumeDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .build();
    }

    public User toEntity(UserCreateDTO dto, UserCredential userCredential, List<Role> roles) {
        return User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .active(true)
                .userCredential(userCredential)
                .roles(roles != null ? roles : List.of())
                .build();
    }
}
