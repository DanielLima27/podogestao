package com.podogestao.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DermatologicalChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean onychomycosis;
    private boolean onychophosis;
    private boolean onycholysis;
    private boolean onychogryphosis;
    private boolean granuloma;
    private boolean onychocryptosis;
    private boolean onychotrophy;
    private boolean onychorrhexis;
    private boolean nailPsoriasis;

}
