package com.bookademic.bookademic.mappers;

import com.bookademic.bookademic.dto.degreeProgram.DegreeProgramCreateDTO;
import com.bookademic.bookademic.dto.degreeProgram.DegreeProgramResponseAdminDTO;
import com.bookademic.bookademic.entities.DegreeProgram;

public class DegreeProgramMapper {
    public DegreeProgramResponseAdminDTO toAdminDto(DegreeProgram entity){
        String s = entity.getActive() == true ? "true" : "false";
        return DegreeProgramResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .isActive(s)
//                .subjects()
                .build();
    }

    public DegreeProgramResponseAdminDTO toUserDto(DegreeProgram entity){
        return DegreeProgramResponseAdminDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
//                .subjects()
                .build();
    }

    public DegreeProgram toEntity(DegreeProgramCreateDTO dto) {
        return DegreeProgram.builder()
                .code(dto.getCode())
                .name(dto.getName())
                .active(true)
                .build();
    }
}
