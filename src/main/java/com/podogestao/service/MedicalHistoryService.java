package com.podogestao.service;


import com.podogestao.controller.request.MedicalHistoryRequest;
import com.podogestao.controller.response.MedicalHistoryResponse;
import com.podogestao.entity.MedicalHistory;
import com.podogestao.mapper.MedicalHistoryMapper;
import com.podogestao.repository.MedicalHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {


    private final MedicalHistoryRepository repository;
    private final MedicalHistoryMapper mapper;


    public MedicalHistoryResponse create(MedicalHistoryRequest request) {
        MedicalHistory medicalHistory = mapper.toEntity(request);
        medicalHistory.setAllergicTo(Boolean.TRUE.equals(request.allergic())
                ? request.allergicTo()
                : "S/A");
        repository.save(medicalHistory);
        return mapper.toResponse(medicalHistory);
    }

    public List<MedicalHistoryResponse> findAllMedicalHistories() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Optional<MedicalHistoryResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    public Optional<MedicalHistoryResponse> update(Long id, MedicalHistoryRequest request) {
        return repository.findById(id)
                .map(history -> {
                    history.setAllergic(request.allergic());

                    history.setAllergicTo(Boolean.TRUE.equals(request.allergic())
                            ? request.allergicTo()
                            : "S/A");

                    history.setFootwearType(request.footwearType());
                    history.setFootwearNumber(request.footwearNumber());
                    history.setMainComplaint(request.mainComplaint());
                    history.setLowerLimbSurgery(request.lowerLimbSurgery());
                    history.setSurgeryDetails(request.surgeryDetails());
                    history.setPracticesSports(request.practicesSports());
                    history.setSportType(request.sportType());
                    history.setSportFrequency(request.sportFrequency());
                    history.setSportFootwear(request.sportFootwear());
                    history.setUsesMedication(request.usesMedication());
                    history.setMedicationDetails(request.medicationDetails());
                    history.setPregnant(request.pregnant());
                    history.setPainSensitivity(request.painSensitivity());
                    history.setHypertension(request.hypertension());
                    history.setHeartDisease(request.heartDisease());
                    history.setSeizures(request.seizures());
                    history.setHepatitis(request.hepatitis());
                    history.setKidneyDisease(request.kidneyDisease());
                    history.setHemodialysis(request.hemodialysis());
                    history.setVaricoseVeins(request.varicoseVeins());
                    history.setPeripheralNeuropathy(request.peripheralNeuropathy());
                    history.setSmoker(request.smoker());
                    history.setPsoriasis(request.psoriasis());
                    history.setOncologicalHistory(request.oncologicalHistory());
                    history.setVascularImpairment(request.vascularImpairment());
                    history.setPacemakerOrPins(request.pacemakerOrPins());

                    repository.save(history);
                    return mapper.toResponse(history);
                });
    }


    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
