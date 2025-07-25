package com.podogestao.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anamnesis")
@ToString(exclude = "patient")
public class Anamnesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_allergic")
    private Boolean isAllergic;

    private String allergy;

    @Column(name = "footwear_type")
    private String footwearType;

    @Column(name = "footwear_size")
    private Integer footwearSize;

    private String complaint;

    @Column(name = "has_surgery")
    private Boolean hasSurgery;

    @Column(name = "surgery_details")
    private String surgeryDetails;

    @Column(name = "plays_sports")
    private Boolean playsSports;

    private String sport;

    private String frequency;

    @Column(name = "sport_footwear")
    private String sportFootwear;

    @Column(name = "takes_medication")
    private Boolean takesMedication;

    private String medication;

    private Boolean pregnant;

    @Column(name = "pain_sensitivity")
    private String painSensitivity;

    private Boolean hypertension;

    @Column(name = "heart_condition")
    private Boolean heartCondition;

    private Boolean seizures;

    private Boolean hepatitis;

    private Boolean nephropathy;

    private Boolean dialysis;

    @Column(name = "varicose_veins")
    private Boolean varicoseVeins;

    private Boolean neuropathy;

    private Boolean smoker;

    private Boolean psoriasis;

    @Column(name = "cancer_history")
    private Boolean cancerHistory;

    @Column(name = "vascular_issue")
    private Boolean vascularIssue;

    private Boolean pacemaker;

    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false, unique = true)
    private Patient patient;


}
