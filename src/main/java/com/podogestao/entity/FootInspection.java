package com.podogestao.entity;

import com.podogestao.enums.FootCondition;
import com.podogestao.enums.FootType;
import com.podogestao.enums.PerfusionType;
import com.podogestao.enums.ToeType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "foot_inspection")
@Data
public class FootInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ToeType toeType;

    @Enumerated(EnumType.STRING)
    private FootType footType;

    @Enumerated(EnumType.STRING)
    private PerfusionType perfusionType;

    @ElementCollection(targetClass = FootCondition.class)
    @CollectionTable(
            name = "foot_inspection_conditions",
            joinColumns = @JoinColumn(name = "foot_inspection_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<FootCondition> conditions;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "dermatological_changes_id")
    private DermatologicalChanges dermatologicalChanges;


}