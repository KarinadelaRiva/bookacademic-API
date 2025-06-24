package com.bookademic.bookademic.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(of = {"id"})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reservation_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false
    )
    private LocalDate startDate;

    @Column(
            nullable = false
    )
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false
    )
    private DayOfWeek dayOfWeek;

    @Column(
            nullable = false
    )
    private LocalTime startTime;

    @Column(
            nullable = false
    )
    private LocalTime endTime;

    @Column(
            nullable = false
    )
    private Boolean active = true;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "space_id", nullable = false)
    @JsonBackReference
    private Space space;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "requester_id", nullable = false)
    @JsonBackReference
    private User requester;
}
