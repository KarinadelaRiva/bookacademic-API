package com.bookademic.bookademic.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Builder
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 50
    )
    private String name;

    @Column(
            unique = true,
            length = 6
    )
    private String code;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private Boolean requiresLab = false;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT FALSE"
    )
    private Boolean requiresWorkshop = false;

    @Column(
            nullable = false,
            columnDefinition = "BOOLEAN DEFAULT TRUE"
    )
    private Boolean active = true;

    @ManyToMany(
            mappedBy = "subjects"
    )
    @JsonBackReference
    private List<DegreeProgram> degreePrograms;

    @OneToMany(
            mappedBy = "subject",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ClassGroup> classGroups;

}
