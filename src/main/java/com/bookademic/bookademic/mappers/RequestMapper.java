package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.request.ClassRequest.ClassRequestCreateDTO;
import com.bookademic.bookademic.dto.request.ClassRequest.ClassRequestResponseDTO;
import com.bookademic.bookademic.dto.request.EventRequest.EventRequestCreateDTO;
import com.bookademic.bookademic.dto.request.EventRequest.EventRequestResponseDTO;
import com.bookademic.bookademic.dto.request.RequestCreateDTO;
import com.bookademic.bookademic.dto.request.RequestResponseDTO;
import com.bookademic.bookademic.dto.request.RequestResponseResumeDTO;
import com.bookademic.bookademic.entities.*;
import com.bookademic.bookademic.enums.RequestState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RequestMapper {

    private final UserMapper userMapper;
    private final SpaceMapper spaceMapper;
    private final ReservationMapper reservationMapper;
    private final ClassGroupMapper classGroupMapper;
    private final EventMapper eventMapper;

    @Autowired
    public RequestMapper(UserMapper userMapper,
                         SpaceMapper spaceMapper,
                         ReservationMapper reservationMapper,
                         ClassGroupMapper classGroupMapper,
                         EventMapper eventMapper) {
        this.userMapper = userMapper;
        this.spaceMapper = spaceMapper;
        this.reservationMapper = reservationMapper;
        this.classGroupMapper = classGroupMapper;
        this.eventMapper = eventMapper;
    }

    public RequestResponseDTO toResponseDTO(Request entity) {
        switch (entity) {
            case ClassRequest classRequest -> {
                return ClassRequestResponseDTO.builder()
                        .id(classRequest.getId())
                        .createdAt(classRequest.getCreatedAt())
                        .state(classRequest.getState())
                        .requester(userMapper.toResumeDTO(classRequest.getRequester()))
                        .originalReservation(reservationMapper.toResumeDTO(classRequest.getOriginalReservation()))
                        .space(spaceMapper.toResumeDTO(classRequest.getRequestedSpace()))
                        .startDate(classRequest.getStartDate())
                        .endDate(classRequest.getEndDate())
                        .startTime(classRequest.getStartTime())
                        .endTime(classRequest.getEndTime())
                        .dayOfWeek(classRequest.getDayOfWeek())
                        .requesterComment(classRequest.getRequesterComment())
                        .adminComment(classRequest.getAdminComment())
                        .classGroup(classGroupMapper.toResumeDTO(classRequest.getClassGroup()))
                        .build();
            }
            case EventRequest eventRequest -> {
                return EventRequestResponseDTO.builder()
                        .id(eventRequest.getId())
                        .createdAt(eventRequest.getCreatedAt())
                        .state(eventRequest.getState())
                        .requester(userMapper.toResumeDTO(eventRequest.getRequester()))
                        .originalReservation(reservationMapper.toResumeDTO(eventRequest.getOriginalReservation()))
                        .space(spaceMapper.toResumeDTO(eventRequest.getRequestedSpace()))
                        .startDate(eventRequest.getStartDate())
                        .endDate(eventRequest.getEndDate())
                        .startTime(eventRequest.getStartTime())
                        .endTime(eventRequest.getEndTime())
                        .dayOfWeek(eventRequest.getDayOfWeek())
                        .requesterComment(eventRequest.getRequesterComment())
                        .adminComment(eventRequest.getAdminComment())
                        .event(eventMapper.toResumeDTO(eventRequest.getEvent()))
                        .build();
            }
            default -> throw new IllegalArgumentException("Unsupported request type: " + entity.getClass().getSimpleName());
        }
    }

    public RequestResponseResumeDTO toResumeDTO(Request entity) {
        return RequestResponseResumeDTO.builder()
                .id(entity.getId())
                .createdAt(entity.getCreatedAt())
                .state(entity.getState())
                .typeRequest(entity.getClass().getSimpleName())
                .adminComment(entity.getAdminComment())
                .build();
    }

    public Request toEntity(RequestCreateDTO dto,
                            User requester,
                            Reservation originalReservation,
                            Space requestedSpace,
                            ClassGroup classGroup,
                            Event event) {
        return switch (dto) {
            case ClassRequestCreateDTO classRequest -> ClassRequest.builder()
                    .createdAt(LocalDateTime.now())
                    .state(RequestState.PENDING)
                    .requester(requester)
                    .originalReservation(originalReservation)
                    .requestedSpace(requestedSpace)
                    .startDate(classRequest.getStartDate())
                    .endDate(classRequest.getEndDate())
                    .startTime(classRequest.getStartTime())
                    .endTime(classRequest.getEndTime())
                    .dayOfWeek(classRequest.getDayOfWeek())
                    .requesterComment(classRequest.getRequesterComment())
                    .classGroup(classGroup)
                    .build();
            case EventRequestCreateDTO eventRequest -> EventRequest.builder()
                    .createdAt(LocalDateTime.now())
                    .state(RequestState.PENDING)
                    .requester(requester)
                    .originalReservation(originalReservation)
                    .requestedSpace(requestedSpace)
                    .startDate(eventRequest.getStartDate())
                    .endDate(eventRequest.getEndDate())
                    .startTime(eventRequest.getStartTime())
                    .endTime(eventRequest.getEndTime())
                    .dayOfWeek(eventRequest.getDayOfWeek())
                    .requesterComment(eventRequest.getRequesterComment())
                    .event(event)
                    .build();
            default -> throw new IllegalArgumentException("Unsupported request type: " + dto.getClass().getSimpleName());
        };
    }
}
