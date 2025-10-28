package com.podogestao.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "professional_observations")
public class ProfessionalObservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observationNotes;
    private String procedure;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String podologistName;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PodologicalInspection podologicalInspection;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ConsentTerm consentTerm;

}

