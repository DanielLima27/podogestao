package com.podogestao.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private Boolean allergic;
   private String allergicTo;

   private String footwearType;
   private String footwearNumber;

   private String mainComplaint;

    private Boolean lowerLimbSurgery;
    private String surgeryDetails;

    private Boolean practicesSports;
    private String sportType;
    private String sportFrequency;
    private String sportFootwear;

    private Boolean usesMedication;
    private String medicationDetails;

    private Boolean pregnant;

    private String painSensitivity;

    private Boolean hypertension;
    private Boolean heartDisease;
    private Boolean seizures;
    private Boolean hepatitis;
    private Boolean kidneyDisease;
    private Boolean hemodialysis;
    private Boolean varicoseVeins;
    private Boolean peripheralNeuropathy;
    private Boolean smoker;
    private Boolean psoriasis;
    private Boolean oncologicalHistory;
    private Boolean vascularImpairment;
    private Boolean pacemakerOrPins;
}
