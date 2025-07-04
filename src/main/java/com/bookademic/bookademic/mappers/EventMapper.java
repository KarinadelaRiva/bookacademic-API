package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.event.EventCreateDTO;
import com.bookademic.bookademic.domain.dto.event.EventResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.event.EventResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.event.EventResponseUserDTO;
import com.bookademic.bookademic.domain.entities.Event;
import com.bookademic.bookademic.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventResponseAdminDTO toResponseAdminDTO(Event entity) {
        return EventResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .organizerName(entity.getOrganizer().getFirstName() + " " + entity.getOrganizer().getLastName())
                .organizerEmail(entity.getOrganizer().getEmail())
                .maxParticipants(entity.getMaxParticipants())
                .isActive(entity.getActive())
                .build();
    }

    public EventResponseUserDTO toResponseUserDTO(Event entity) {
        return EventResponseUserDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .organizerName(entity.getOrganizer().getFirstName() + " " + entity.getOrganizer().getLastName())
                .maxParticipants(entity.getMaxParticipants())
                .build();
    }

    public EventResponseResumeDTO toResumeDTO(Event entity) {
        return EventResponseResumeDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public Event toEntity(EventCreateDTO dto, User organizer) {
        return Event.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .description(dto.getDescription())
                .maxParticipants(dto.getMaxParticipants())
                .organizer(organizer)
                .build();
    }

}
