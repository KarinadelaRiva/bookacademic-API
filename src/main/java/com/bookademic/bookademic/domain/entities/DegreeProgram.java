package com.bookademic.bookademic.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@Builder
@Entity
public class DegreeProgram {

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
            length = 50,
            unique = true
    )
    private String name;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active = true;

    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "degree_program_subject",
            joinColumns = @JoinColumn(name = "degree_program_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    @JsonManagedReference
    private List<Subject> subjects;

}
