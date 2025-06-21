package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.subject.SubjectCreateDTO;
import com.bookademic.bookademic.dto.subject.SubjectResponseAdminDTO;
import com.bookademic.bookademic.dto.subject.SubjectResponseResumeDTO;
import com.bookademic.bookademic.dto.subject.SubjectResponseUserDTO;
import com.bookademic.bookademic.entities.DegreeProgram;
import com.bookademic.bookademic.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubjectMapper {

    private final DegreeProgramMapper degreeProgramMapper;

    @Autowired
    public SubjectMapper(@Lazy DegreeProgramMapper degreeProgramMapper) {
        this.degreeProgramMapper = degreeProgramMapper;
    }

    public SubjectResponseAdminDTO toAdminDTO(Subject entity){
        return SubjectResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .requiresLab(entity.getRequiresLab())
                .requiresWorkshop(entity.getRequiresWorkshop())
                .isActive(entity.getActive())
                .degreePrograms(entity.getDegreePrograms().stream()
                        .map(degreeProgramMapper::toResumeDTO)
                        .toList())
                .build();
    }

    public SubjectResponseUserDTO toUserDTO(Subject entity){
        return SubjectResponseUserDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .requiresLab(entity.getRequiresLab())
                .requiresWorkshop(entity.getRequiresWorkshop())
                .degreePrograms(entity.getDegreePrograms().stream()
                        .map(dp -> dp.getCode() + " - " + dp.getName())
                        .toList())
                .build();
    }

    public SubjectResponseResumeDTO toResumeDTO(Subject entity) {
        return SubjectResponseResumeDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public Subject toEntity(SubjectCreateDTO dto, List<DegreeProgram> degreePrograms) {
        return Subject.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .requiresLab(dto.getRequiresLab())
                .requiresWorkshop(dto.getRequiresWorkshop())
                .active(true)
                .degreePrograms(degreePrograms != null ? degreePrograms : List.of())
                .build();
    }

}
