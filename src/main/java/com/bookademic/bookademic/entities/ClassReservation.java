package com.bookademic.bookademic.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DiscriminatorValue("CLASS_RESERVATION")
public class ClassReservation extends Reservation{

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "class_group_id",
            nullable = false
    )
    @JsonBackReference
    private ClassGroup classGroup;
}
