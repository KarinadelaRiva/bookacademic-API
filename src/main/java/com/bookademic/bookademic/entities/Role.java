package com.bookademic.bookademic.entities;

import com.bookademic.bookademic.enums.Permission;
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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 50,
            unique = true
    )
    private String name;

    @Column(
            nullable = false,
            length = 6,
            unique = true
    )
    private String code;

    @Column(
            length = 300
    )
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id")
    )
    @Column(name = "permission")
    private List<Permission> permissions;

    @ManyToMany(
            mappedBy = "roles",
            fetch = FetchType.LAZY
    )
    private List<User> users;

}
