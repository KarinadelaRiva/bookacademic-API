package com.bookademic.bookademic.domain.entities;

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
@DiscriminatorValue("EVENT_REQUEST")
public class EventRequest extends Request {

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "event_id",
            nullable = false
    )
    private Event event;

}
