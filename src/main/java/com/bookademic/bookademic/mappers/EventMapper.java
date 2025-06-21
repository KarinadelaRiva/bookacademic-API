package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.event.EventCreateDTO;
import com.bookademic.bookademic.dto.event.EventResponseAdminDTO;
import com.bookademic.bookademic.dto.event.EventResponseResumeDTO;
import com.bookademic.bookademic.dto.event.EventResponseUserDTO;
import com.bookademic.bookademic.entities.Event;
import com.bookademic.bookademic.entities.User;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public EventResponseAdminDTO toAdminDTO(Event entity) {
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

    public EventResponseUserDTO toUserDTO(Event entity) {
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
