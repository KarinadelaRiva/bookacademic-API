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
@DiscriminatorValue("EVENT_RESERVATION")
public class EventReservation extends Reservation {

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "event_id",
            nullable = false
    )
    @JsonBackReference
    private Event event;
}
