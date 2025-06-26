package com.bookademic.bookademic.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 30
    )
    private String firstName;

    @Column(
            nullable = false,
            length = 30
    )
    private String lastName;

    @Column(
            nullable = false,
            length = 50,
            unique = true
    )
    private String email;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active = true;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @JoinColumn(
            name = "credential_id",
            referencedColumnName = "id"
    )
    private UserCredential userCredential;

    @OneToMany(
            mappedBy = "professor",
            fetch = FetchType.LAZY
    )
    private List<ClassGroup> classGroups;

    @OneToMany(
            mappedBy = "organizer",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Event> events;

    @OneToMany(
            mappedBy = "requester",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Request> requests;

    @OneToMany(
            mappedBy = "requester",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Reservation> reservations;

}
