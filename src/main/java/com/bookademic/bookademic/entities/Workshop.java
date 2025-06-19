package com.bookademic.bookademic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("WORKSHOP")
public class Workshop extends Space {

    @Column(
            nullable = false,
            columnDefinition = "INTEGER DEFAULT 0"
    )
    private Integer numberOfWorkstations = 0;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private Boolean hasTools = false;
}
