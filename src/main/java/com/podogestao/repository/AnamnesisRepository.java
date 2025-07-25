package com.podogestao.repository;

import com.podogestao.entity.Anamnesis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnamnesisRepository extends JpaRepository<Anamnesis, Long> {
    Optional<Anamnesis> findByPatientId(Long patientId);
}
