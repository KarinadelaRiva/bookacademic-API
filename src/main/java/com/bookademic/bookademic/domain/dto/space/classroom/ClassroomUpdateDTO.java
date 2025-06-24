package com.bookademic.bookademic.domain.dto.space.classroom;

import com.bookademic.bookademic.domain.dto.space.SpaceUpdateDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class ClassroomUpdateDTO extends SpaceUpdateDTO {
}
