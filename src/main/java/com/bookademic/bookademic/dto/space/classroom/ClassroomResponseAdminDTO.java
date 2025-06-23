package com.bookademic.bookademic.dto.space.classroom;

import com.bookademic.bookademic.dto.space.SpaceCreateDTO;
import com.bookademic.bookademic.dto.space.SpaceResponseAdminDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClassroomResponseAdminDTO extends SpaceResponseAdminDTO {
}
