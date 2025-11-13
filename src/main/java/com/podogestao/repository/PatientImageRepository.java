package com.podogestao.repository;

import com.podogestao.entity.PatientImages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientImageRepository extends JpaRepository<PatientImages, Long> {
    List<PatientImages> findByPatientId(Long patientId);
}