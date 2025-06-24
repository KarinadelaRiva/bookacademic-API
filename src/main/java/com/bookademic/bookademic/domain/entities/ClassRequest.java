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
@DiscriminatorValue("CLASS_REQUEST")
public class ClassRequest extends Request{

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "class_group_id", nullable = false)
    private ClassGroup classGroup;
}
