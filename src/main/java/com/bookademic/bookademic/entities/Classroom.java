package com.bookademic.bookademic.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@DiscriminatorValue("CLASSROOM")
public class Classroom extends Space{
}
