package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.space.*;
import com.bookademic.bookademic.entities.*;
import org.springframework.stereotype.Component;

@Component
public class SpaceMapper {

    public Space toEntity(SpaceCreateDTO dto) {
        return switch (dto) {
            case LabCreateDTO labDto -> Lab.builder()
                    .code(labDto.getCode())
                    .name(labDto.getName())
                    .capacity(labDto.getCapacity())
                    .hasProjector(labDto.getHasProjector())
                    .hasTV(labDto.getHasTV())
                    .numberOfComputers(labDto.getNumberOfComputers())
                    .hasSpecialEquipment(labDto.getHasSpecialEquipment())
                    .active(true)
                    .build();
            case WorkshopCreateDTO workshopDto -> Workshop.builder()
                    .code(workshopDto.getCode())
                    .name(workshopDto.getName())
                    .capacity(workshopDto.getCapacity())
                    .hasProjector(workshopDto.getHasProjector())
                    .hasTV(workshopDto.getHasTV())
                    .numberOfWorkstations(workshopDto.getNumberOfWorkstations())
                    .hasTools(workshopDto.getHasTools())
                    .active(true)
                    .build();
            case MultipurposeRoomCreateDTO multiDto -> MultipurposeRoom.builder()
                    .code(multiDto.getCode())
                    .name(multiDto.getName())
                    .capacity(multiDto.getCapacity())
                    .hasProjector(multiDto.getHasProjector())
                    .hasTV(multiDto.getHasTV())
                    .hasStage(multiDto.getHasStage())
                    .hasAudioVisualEquipment(multiDto.getHasAudioVisualEquipment())
                    .active(true)
                    .build();
            case ClassroomCreateDTO classroomDto -> Classroom.builder()
                    .code(classroomDto.getCode())
                    .name(classroomDto.getName())
                    .capacity(classroomDto.getCapacity())
                    .hasProjector(classroomDto.getHasProjector())
                    .hasTV(classroomDto.getHasTV())
                    .active(true)
                    .build();
            case null, default -> throw new IllegalArgumentException("Tipo de espacio desconocido");
        };
    }

}
