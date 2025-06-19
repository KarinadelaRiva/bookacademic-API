package com.bookademic.bookademic.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = true,
            unique = true,
            length = 6
    )
    private String code;

    @Column(
            nullable = false,
            length = 100
    )
    private String name;

    @Column(
            nullable = true,
            length = 500
    )
    private String description;

    @Column(
            nullable = false,
            columnDefinition = "INTEGER DEFAULT 10"
    )
    private Integer maxParticipants = 0;

    @Column(
            nullable = false
    )
    private LocalDateTime startDateTime;

    @Column(
            nullable = false
    )
    private LocalDateTime endDateTime;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active = true;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "organizer_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User organizer;

    @OneToMany(
            mappedBy = "event",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<EventRequest> requests;

    @OneToMany(
            mappedBy = "event",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<EventReservation> reservations;
}
