package com.podogestao.entity;


import com.podogestao.enums.FootCondition;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class PodologicalInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "right_foot_inspection_id")
    private FootInspection rightFoot;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "left_foot_inspection_id")
    private FootInspection leftFoot;

    @ElementCollection(targetClass = FootCondition.class)
    @CollectionTable(
            name = "podological_inspection_conditions",
            joinColumns = @JoinColumn(name = "podological_inspection_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "condition")
    private Set<FootCondition> conditions;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DermatologicalChanges dermatologicalChanges;
}

