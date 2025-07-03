package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.space.SpaceCreateDTO;
import com.bookademic.bookademic.domain.dto.space.SpaceResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.space.SpaceResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.space.SpaceResponseUserDTO;
import com.bookademic.bookademic.domain.entities.*;
import com.bookademic.bookademic.domain.dto.space.classroom.ClassroomCreateDTO;
import com.bookademic.bookademic.domain.dto.space.classroom.ClassroomResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.space.classroom.ClassroomResponseUserDTO;
import com.bookademic.bookademic.domain.dto.space.lab.LabCreateDTO;
import com.bookademic.bookademic.domain.dto.space.lab.LabResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.space.lab.LabResponseUserDTO;
import com.bookademic.bookademic.domain.dto.space.multipurposeRoom.MultipurposeRoomCreateDTO;
import com.bookademic.bookademic.domain.dto.space.multipurposeRoom.MultipurposeRoomResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.space.multipurposeRoom.MultipurposeRoomResponseUserDTO;
import com.bookademic.bookademic.domain.dto.space.workshop.WorkshopCreateDTO;
import com.bookademic.bookademic.domain.dto.space.workshop.WorkshopResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.space.workshop.WorkshopResponseUserDTO;
import com.bookademic.bookademic.exceptions.domainExceptions.unsupportedType.UnsupportedSpaceTypeException;
import org.springframework.stereotype.Component;

@Component
public class SpaceMapper {

    public SpaceResponseAdminDTO toResponseAdminDTO(Space entity) {
        String type = entity.getClass().getSimpleName();
        switch (entity){
            case Lab lab -> {
                return LabResponseAdminDTO.builder()
                        .id(lab.getId())
                        .code(lab.getCode())
                        .type(type)
                        .name(lab.getName())
                        .capacity(lab.getCapacity())
                        .hasProjector(lab.getHasProjector())
                        .hasTV(lab.getHasTV())
                        .isActive(lab.getActive())
                        .numberOfComputers(lab.getNumberOfComputers())
                        .hasSpecialEquipment(lab.getHasSpecialEquipment())
                        .build();
            }
            case Workshop workshop -> {
                return WorkshopResponseAdminDTO.builder()
                        .id(workshop.getId())
                        .code(workshop.getCode())
                        .type(type)
                        .name(workshop.getName())
                        .capacity(workshop.getCapacity())
                        .hasProjector(workshop.getHasProjector())
                        .hasTV(workshop.getHasTV())
                        .numberOfWorkstations(workshop.getNumberOfWorkstations())
                        .hasTools(workshop.getHasTools())
                        .isActive(workshop.getActive())
                        .build();
            }
            case MultipurposeRoom multi -> {
                return MultipurposeRoomResponseAdminDTO.builder()
                        .id(multi.getId())
                        .code(multi.getCode())
                        .type(type)
                        .name(multi.getName())
                        .capacity(multi.getCapacity())
                        .hasProjector(multi.getHasProjector())
                        .hasTV(multi.getHasTV())
                        .hasStage(multi.getHasStage())
                        .hasAudioVisualEquipment(multi.getHasAudioVisualEquipment())
                        .isActive(multi.getActive())
                        .build();
            }
            case Classroom classroom -> {
                return ClassroomResponseAdminDTO.builder()
                        .id(classroom.getId())
                        .code(classroom.getCode())
                        .type(type)
                        .name(classroom.getName())
                        .capacity(classroom.getCapacity())
                        .hasProjector(classroom.getHasProjector())
                        .hasTV(classroom.getHasTV())
                        .isActive(classroom.getActive())
                        .build();
            }
            default -> throw new UnsupportedSpaceTypeException(entity.getClass().getSimpleName());
        }
    }

    public SpaceResponseUserDTO toResponseUserDTO(Space entity) {
        String type = entity.getClass().getSimpleName();
        return switch (entity) {
            case Lab lab -> LabResponseUserDTO.builder()
                    .id(lab.getId())
                    .code(lab.getCode())
                    .type(type)
                    .name(lab.getName())
                    .capacity(lab.getCapacity())
                    .hasProjector(lab.getHasProjector())
                    .hasTV(lab.getHasTV())
                    .build();
            case Workshop workshop -> WorkshopResponseUserDTO.builder()
                    .id(workshop.getId())
                    .code(workshop.getCode())
                    .type(type)
                    .name(workshop.getName())
                    .capacity(workshop.getCapacity())
                    .hasProjector(workshop.getHasProjector())
                    .hasTV(workshop.getHasTV())
                    .build();
            case MultipurposeRoom multi -> MultipurposeRoomResponseUserDTO.builder()
                    .id(multi.getId())
                    .code(multi.getCode())
                    .type(type)
                    .name(multi.getName())
                    .capacity(multi.getCapacity())
                    .hasProjector(multi.getHasProjector())
                    .hasTV(multi.getHasTV())
                    .build();
            case Classroom classroom -> ClassroomResponseUserDTO.builder()
                    .id(classroom.getId())
                    .code(classroom.getCode())
                    .type(type)
                    .name(classroom.getName())
                    .capacity(classroom.getCapacity())
                    .hasProjector(classroom.getHasProjector())
                    .hasTV(classroom.getHasTV())
                    .build();
            default -> throw new UnsupportedSpaceTypeException(entity.getClass().getSimpleName());
        };
    }

    public SpaceResponseResumeDTO toResumeDTO(Space entity) {
        return SpaceResponseResumeDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .type(entity.getClass().getSimpleName())
                .name(entity.getName())
                .build();
    }

    public Space toEntity(SpaceCreateDTO dto) {
        return switch (dto) {
            case LabCreateDTO labDto -> Lab.builder()
                    .code(labDto.getCode().toUpperCase())
                    .name(labDto.getName().toUpperCase())
                    .capacity(labDto.getCapacity())
                    .hasProjector(labDto.getHasProjector())
                    .hasTV(labDto.getHasTV())
                    .numberOfComputers(labDto.getNumberOfComputers())
                    .hasSpecialEquipment(labDto.getHasSpecialEquipment())
                    .active(true)
                    .build();
            case WorkshopCreateDTO workshopDto -> Workshop.builder()
                    .code(workshopDto.getCode().toUpperCase())
                    .name(workshopDto.getName().toUpperCase())
                    .capacity(workshopDto.getCapacity())
                    .hasProjector(workshopDto.getHasProjector())
                    .hasTV(workshopDto.getHasTV())
                    .numberOfWorkstations(workshopDto.getNumberOfWorkstations())
                    .hasTools(workshopDto.getHasTools())
                    .active(true)
                    .build();
            case MultipurposeRoomCreateDTO multiDto -> MultipurposeRoom.builder()
                    .code(multiDto.getCode().toUpperCase())
                    .name(multiDto.getName().toUpperCase())
                    .capacity(multiDto.getCapacity())
                    .hasProjector(multiDto.getHasProjector())
                    .hasTV(multiDto.getHasTV())
                    .hasStage(multiDto.getHasStage())
                    .hasAudioVisualEquipment(multiDto.getHasAudioVisualEquipment())
                    .active(true)
                    .build();
            case ClassroomCreateDTO classroomDto -> Classroom.builder()
                    .code(classroomDto.getCode().toUpperCase())
                    .name(classroomDto.getName().toUpperCase())
                    .capacity(classroomDto.getCapacity())
                    .hasProjector(classroomDto.getHasProjector())
                    .hasTV(classroomDto.getHasTV())
                    .active(true)
                    .build();
            default -> throw new UnsupportedSpaceTypeException(dto.getClass().getSimpleName());

        };
    }

}
