package com.bookademic.bookademic.dto.space.classroom;

import com.bookademic.bookademic.dto.space.SpaceCreateDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClassroomCreateDTO extends SpaceCreateDTO {
}
