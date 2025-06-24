package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.reservation.ClassReservation.ClassReservationCreateDTO;
import com.bookademic.bookademic.domain.dto.reservation.ClassReservation.ClassReservationResponseDTO;
import com.bookademic.bookademic.domain.dto.reservation.EventReservation.EventReservationCreateDTO;
import com.bookademic.bookademic.domain.dto.reservation.EventReservation.EventReservationResponseDTO;
import com.bookademic.bookademic.domain.dto.reservation.ReservationCreateDTO;
import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseDTO;
import com.bookademic.bookademic.domain.dto.reservation.ReservationResponseResumeDTO;
import com.bookademic.bookademic.domain.entities.*;
import com.bookademic.bookademic.exceptions.domainExceptions.UnsupportedReservationTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    private final SpaceMapper spaceMapper;
    private final UserMapper userMapper;
    private final ClassGroupMapper classGroupMapper;
    private final EventMapper eventMapper;

    @Autowired
    public ReservationMapper(SpaceMapper spaceMapper,
                             UserMapper userMapper,
                             ClassGroupMapper classGroupMapper,
                            EventMapper eventMapper) {
        this.spaceMapper = spaceMapper;
        this.userMapper = userMapper;
        this.classGroupMapper = classGroupMapper;
        this.eventMapper = eventMapper;
    }

    public ReservationResponseDTO toResponseDTO(Reservation entity){
        switch(entity){
            case ClassReservation classReservation -> {
                return ClassReservationResponseDTO.builder()
                        .id(classReservation.getId())
                        .startDate(classReservation.getStartDate())
                        .endDate(classReservation.getEndDate())
                        .startTime(classReservation.getStartTime())
                        .endTime(classReservation.getEndTime())
                        .dayOfWeek(classReservation.getDayOfWeek())
                        .space(spaceMapper.toResumeDTO(classReservation.getSpace()))
                        .requester(userMapper.toResumeDTO(classReservation.getRequester()))
                        .classGroup(classGroupMapper.toResumeDTO(classReservation.getClassGroup()))
                        .build();
            }
            case EventReservation eventReservation -> {
                return EventReservationResponseDTO.builder()
                        .id(eventReservation.getId())
                        .startDate(eventReservation.getStartDate())
                        .endDate(eventReservation.getEndDate())
                        .startTime(eventReservation.getStartTime())
                        .endTime(eventReservation.getEndTime())
                        .dayOfWeek(eventReservation.getDayOfWeek())
                        .space(spaceMapper.toResumeDTO(eventReservation.getSpace()))
                        .requester(userMapper.toResumeDTO(eventReservation.getRequester()))
                        .event(eventMapper.toResumeDTO(eventReservation.getEvent()))
                        .build();
            }
            default -> throw new UnsupportedReservationTypeException(entity.getClass().getSimpleName());
        }
    }

    public ReservationResponseResumeDTO toResumeDTO(Reservation entity) {
        return ReservationResponseResumeDTO.builder()
                .id(entity.getId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .dayOfWeek(entity.getDayOfWeek())
                .space(spaceMapper.toResumeDTO(entity.getSpace()))
                .classOrEventName(entity instanceof ClassReservation
                        ? ((ClassReservation) entity).getClassGroup().getName()
                        : ((EventReservation) entity).getEvent().getName())
                .classOrEventResponsibleName(entity instanceof ClassReservation
                        ? ((ClassReservation) entity).getClassGroup().getProfessor().getFirstName() + " " + ((ClassReservation) entity).getClassGroup().getProfessor().getLastName()
                        : ((EventReservation) entity).getEvent().getOrganizer().getFirstName() + " " + ((EventReservation) entity).getEvent().getOrganizer().getLastName())
                .build();
    }

    public Reservation toEntity(ReservationCreateDTO dto,
                                Space space,
                                User requester,
                                ClassGroup classGroup,
                                Event event) {
        return switch (dto) {
            case ClassReservationCreateDTO classReservationDTO -> ClassReservation.builder()
                    .startDate(classReservationDTO.getStartDate())
                    .endDate(classReservationDTO.getEndDate())
                    .startTime(classReservationDTO.getStartTime())
                    .endTime(classReservationDTO.getEndTime())
                    .dayOfWeek(classReservationDTO.getDayOfWeek())
                    .space(space)
                    .requester(requester)
                    .classGroup(classGroup)
                    .build();
            case EventReservationCreateDTO eventReservationDTO -> EventReservation.builder()
                    .startDate(eventReservationDTO.getStartDate())
                    .endDate(eventReservationDTO.getEndDate())
                    .startTime(eventReservationDTO.getStartTime())
                    .endTime(eventReservationDTO.getEndTime())
                    .dayOfWeek(eventReservationDTO.getDayOfWeek())
                    .space(space)
                    .requester(requester)
                    .event(event)
                    .build();
            default -> throw new UnsupportedReservationTypeException(dto.getClass().getSimpleName());
        };
    }

}
