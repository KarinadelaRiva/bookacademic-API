package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramCreateDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramResponseAdminDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramResponseResumeDTO;
import com.bookademic.bookademic.domain.dto.degreeProgram.DegreeProgramResponseUserDTO;
import com.bookademic.bookademic.domain.entities.DegreeProgram;
import com.bookademic.bookademic.domain.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DegreeProgramMapper {

    private final SubjectMapper subjectMapper;

    @Autowired
    public DegreeProgramMapper(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    public DegreeProgramResponseAdminDTO toResponseAdminDto(DegreeProgram entity){
        return DegreeProgramResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .isActive(entity.getActive())
                .subjects(entity.getSubjects().stream()
                        .map(subjectMapper::toResumeDTO)
                        .toList())
                .build();
    }

    public DegreeProgramResponseUserDTO toResponseUserDto(DegreeProgram entity){
        return DegreeProgramResponseUserDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
//                .subjects()
                .build();
    }

    public DegreeProgramResponseResumeDTO toResumeDTO(DegreeProgram entity) {
        return DegreeProgramResponseResumeDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public DegreeProgram toEntity(DegreeProgramCreateDTO dto, List<Subject> subjects) {
        return DegreeProgram.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .active(true)
                .subjects(subjects != null ? subjects : List.of())
                .build();
    }
}
