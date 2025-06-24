package com.bookademic.bookademic.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"professor", "requests", "reservations"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
public class ClassGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
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
            nullable = false
    )
    private Integer studentCount;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active = true;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "professor_id",
            referencedColumnName = "id",
            nullable = false
    )
    private User professor;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "subject_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Subject subject;

    @OneToMany(
            mappedBy = "classGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ClassRequest> requests;

    @OneToMany(
            mappedBy = "classGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ClassReservation> reservations;
}
