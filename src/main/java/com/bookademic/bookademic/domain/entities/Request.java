package com.bookademic.bookademic.domain.entities;

import com.bookademic.bookademic.domain.enums.RequestState;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public abstract class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false
    )
    private RequestState state = RequestState.PENDING;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "requester_id",
            referencedColumnName = "id",
            nullable = false
    )
    @JsonBackReference
    private User requester;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "original_reservation_id",
            referencedColumnName = "id"
    )
    private Reservation originalReservation;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "requested_space_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Space requestedSpace;

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
            name = "requester_comment",
            columnDefinition = "TEXT"
    )
    private String requesterComment;

    @Column(
            name = "admin_comment",
            columnDefinition = "TEXT"
    )
    private String adminComment;

}
