package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.space.*;
import com.bookademic.bookademic.dto.space.classroom.ClassroomCreateDTO;
import com.bookademic.bookademic.dto.space.classroom.ClassroomResponseAdminDTO;
import com.bookademic.bookademic.dto.space.classroom.ClassroomResponseUserDTO;
import com.bookademic.bookademic.dto.space.lab.LabCreateDTO;
import com.bookademic.bookademic.dto.space.lab.LabResponseAdminDTO;
import com.bookademic.bookademic.dto.space.lab.LabResponseUserDTO;
import com.bookademic.bookademic.dto.space.multipurposeRoom.MultipurposeRoomCreateDTO;
import com.bookademic.bookademic.dto.space.multipurposeRoom.MultipurposeRoomResponseAdminDTO;
import com.bookademic.bookademic.dto.space.multipurposeRoom.MultipurposeRoomResponseUserDTO;
import com.bookademic.bookademic.dto.space.workshop.WorkshopCreateDTO;
import com.bookademic.bookademic.dto.space.workshop.WorkshopResponseAdminDTO;
import com.bookademic.bookademic.dto.space.workshop.WorkshopResponseUserDTO;
import com.bookademic.bookademic.entities.*;
import org.springframework.stereotype.Component;

@Component
public class SpaceMapper {

    public SpaceResponseAdminDTO toAdminDTO(Space entity) {
        switch (entity){
            case Lab lab -> {
                return LabResponseAdminDTO.builder()
                        .id(lab.getId())
                        .code(lab.getCode())
                        .type(entity.getClass().getSimpleName())
                        .name(lab.getName())
                        .capacity(lab.getCapacity())
                        .hasProjector(lab.getHasProjector() ? "true" : "false")
                        .hasTV(lab.getHasTV() ? "true" : "false")
                        .isActive(lab.getActive() ? "true" : "false")
                        .numberOfComputers(lab.getNumberOfComputers())
                        .hasSpecialEquipment(lab.getHasSpecialEquipment().toString())
                        .build();
            }
            case Workshop workshop -> {
                return WorkshopResponseAdminDTO.builder()
                        .id(workshop.getId())
                        .code(workshop.getCode())
                        .type(entity.getClass().getSimpleName())
                        .name(workshop.getName())
                        .capacity(workshop.getCapacity())
                        .hasProjector(workshop.getHasProjector() ? "true" : "false")
                        .hasTV(workshop.getHasTV() ? "true" : "false")
                        .numberOfWorkstations(workshop.getNumberOfWorkstations())
                        .hasTools(workshop.getHasTools() ? "true" : "false")
                        .isActive(workshop.getActive() ? "true" : "false")
                        .build();
            }
            case MultipurposeRoom multi -> {
                return MultipurposeRoomResponseAdminDTO.builder()
                        .id(multi.getId())
                        .code(multi.getCode())
                        .type(entity.getClass().getSimpleName())
                        .name(multi.getName())
                        .capacity(multi.getCapacity())
                        .hasProjector(multi.getHasProjector() ? "true" : "false")
                        .hasTV(multi.getHasTV() ? "true" : "false")
                        .hasStage(multi.getHasStage() ? "true" : "false")
                        .hasAudioVisualEquipment(multi.getHasAudioVisualEquipment() ? "true" : "false")
                        .isActive(multi.getActive() ? "true" : "false")
                        .build();
            }
            case Classroom classroom -> {
                return ClassroomResponseAdminDTO.builder()
                        .id(classroom.getId())
                        .code(classroom.getCode())
                        .type(entity.getClass().getSimpleName())
                        .name(classroom.getName())
                        .capacity(classroom.getCapacity())
                        .hasProjector(classroom.getHasProjector() ? "true" : "false")
                        .hasTV(classroom.getHasTV() ? "true" : "false")
                        .isActive(classroom.getActive() ? "true" : "false")
                        .build();
            }
            default -> throw new IllegalArgumentException("Tipo de espacio desconocido");
        }
    }

    public SpaceResponseUserDTO toUserDTO(Space entity) {
        return switch (entity) {
            case Lab lab -> LabResponseUserDTO.builder()
                    .id(lab.getId())
                    .code(lab.getCode())
                    .type(entity.getClass().getSimpleName())
                    .name(lab.getName())
                    .capacity(lab.getCapacity())
                    .hasProjector(lab.getHasProjector() ? "true" : "false")
                    .hasTV(lab.getHasTV() ? "true" : "false")
                    .build();
            case Workshop workshop -> WorkshopResponseUserDTO.builder()
                    .id(workshop.getId())
                    .code(workshop.getCode())
                    .type(entity.getClass().getSimpleName())
                    .name(workshop.getName())
                    .capacity(workshop.getCapacity())
                    .hasProjector(workshop.getHasProjector() ? "true" : "false")
                    .hasTV(workshop.getHasTV() ? "true" : "false")
                    .build();
            case MultipurposeRoom multi -> MultipurposeRoomResponseUserDTO.builder()
                    .id(multi.getId())
                    .code(multi.getCode())
                    .type(entity.getClass().getSimpleName())
                    .name(multi.getName())
                    .capacity(multi.getCapacity())
                    .hasProjector(multi.getHasProjector() ? "true" : "false")
                    .hasTV(multi.getHasTV() ? "true" : "false")
                    .build();
            case Classroom classroom -> ClassroomResponseUserDTO.builder()
                    .id(classroom.getId())
                    .code(classroom.getCode())
                    .type(entity.getClass().getSimpleName())
                    .name(classroom.getName())
                    .capacity(classroom.getCapacity())
                    .hasProjector(classroom.getHasProjector() ? "true" : "false")
                    .hasTV(classroom.getHasTV() ? "true" : "false")
                    .build();
            default -> throw new IllegalArgumentException("Tipo de espacio desconocido");
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
