package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.classGroup.ClassGroupCreateDTO;
import com.bookademic.bookademic.dto.classGroup.ClassGroupResponseAdminDTO;
import com.bookademic.bookademic.dto.classGroup.ClassGroupResponseResumeDTO;
import com.bookademic.bookademic.dto.classGroup.ClassGroupResponseUserDTO;
import com.bookademic.bookademic.entities.ClassGroup;
import com.bookademic.bookademic.entities.Subject;
import com.bookademic.bookademic.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ClassGroupMapper {

    public ClassGroupResponseAdminDTO toAdminDTO(ClassGroup entity) {
        return ClassGroupResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .studentCount(entity.getStudentCount())
                .isActive(entity.getActive())
                .subjectCode(entity.getSubject().getCode())
                .subjectName(entity.getSubject().getName())
                .professorName(entity.getProfessor().getFirstName() + " " + entity.getProfessor().getLastName())
                .build();
    }

    public ClassGroupResponseUserDTO toUserDTO(ClassGroup entity) {
        return ClassGroupResponseUserDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .studentCount(entity.getStudentCount())
                .subjectCode(entity.getSubject().getCode())
                .subjectName(entity.getSubject().getName())
                .professorName(entity.getProfessor().getFirstName() + " " + entity.getProfessor().getLastName())
                .build();
    }

    public ClassGroupResponseResumeDTO toResumeDTO(ClassGroup entity) {
        return ClassGroupResponseResumeDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public ClassGroup toEntity(ClassGroupCreateDTO dto, Subject subject, User professor) {
        return ClassGroup.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .studentCount(dto.getStudentCount())
                .subject(subject)
                .professor(professor)
                .build();
    }

}
