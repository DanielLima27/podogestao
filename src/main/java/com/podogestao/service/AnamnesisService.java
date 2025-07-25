package com.podogestao.service;

import com.podogestao.entity.Anamnesis;
import com.podogestao.entity.Patient;
import com.podogestao.repository.AnamnesisRepository;
import com.podogestao.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnamnesisService {

    private final AnamnesisRepository repository;
    private final PatientRepository patientRepository;


    public Anamnesis save(Anamnesis anamnesis, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        anamnesis.setPatient(patient);
        return repository.save(anamnesis);
    }

    public List<Anamnesis> findAllAnamnesis() {
        return repository.findAll();
    }

    public Optional<Anamnesis> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Anamnesis> update(Long id, Anamnesis updatedAnamnesis) {
        Optional<Anamnesis> optAnamnesis = repository.findById(id);
        if (optAnamnesis.isPresent()) {
            Anamnesis anamnesis = optAnamnesis.get();

            anamnesis.setIsAllergic(updatedAnamnesis.getIsAllergic());
            anamnesis.setAllergy(updatedAnamnesis.getAllergy());
            anamnesis.setFootwearType(updatedAnamnesis.getFootwearType());
            anamnesis.setFootwearSize(updatedAnamnesis.getFootwearSize());
            anamnesis.setComplaint(updatedAnamnesis.getComplaint());
            anamnesis.setHasSurgery(updatedAnamnesis.getHasSurgery());
            anamnesis.setSurgeryDetails(updatedAnamnesis.getSurgeryDetails());
            anamnesis.setPlaysSports(updatedAnamnesis.getPlaysSports());
            anamnesis.setSport(updatedAnamnesis.getSport());
            anamnesis.setFrequency(updatedAnamnesis.getFrequency());
            anamnesis.setSportFootwear(updatedAnamnesis.getSportFootwear());
            anamnesis.setTakesMedication(updatedAnamnesis.getTakesMedication());
            anamnesis.setMedication(updatedAnamnesis.getMedication());
            anamnesis.setPregnant(updatedAnamnesis.getPregnant());
            anamnesis.setPainSensitivity(updatedAnamnesis.getPainSensitivity());
            anamnesis.setHypertension(updatedAnamnesis.getHypertension());
            anamnesis.setHeartCondition(updatedAnamnesis.getHeartCondition());
            anamnesis.setSeizures(updatedAnamnesis.getSeizures());
            anamnesis.setHepatitis(updatedAnamnesis.getHepatitis());
            anamnesis.setNephropathy(updatedAnamnesis.getNephropathy());
            anamnesis.setDialysis(updatedAnamnesis.getDialysis());
            anamnesis.setVaricoseVeins(updatedAnamnesis.getVaricoseVeins());
            anamnesis.setNeuropathy(updatedAnamnesis.getNeuropathy());
            anamnesis.setSmoker(updatedAnamnesis.getSmoker());
            anamnesis.setPsoriasis(updatedAnamnesis.getPsoriasis());
            anamnesis.setCancerHistory(updatedAnamnesis.getCancerHistory());
            anamnesis.setVascularIssue(updatedAnamnesis.getVascularIssue());
            anamnesis.setPacemaker(updatedAnamnesis.getPacemaker());

            repository.save(anamnesis);
            return Optional.of(anamnesis);
        }
        return Optional.empty();
    }

    public void deleteAnamnesis(Long id) {
        repository.deleteById(id);
    }
}