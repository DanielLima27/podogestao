package com.podogestao.mapper;

import com.podogestao.controller.request.MedicalHistoryRequest;
import com.podogestao.controller.response.MedicalHistoryResponse;
import com.podogestao.entity.MedicalHistory;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {

    MedicalHistory toEntity(MedicalHistoryRequest request);

    MedicalHistoryResponse toResponse(MedicalHistory medicalHistory);

    default void updateEntity(MedicalHistoryRequest request, MedicalHistory entity) {
        if (request == null || entity == null) return;
        entity.setAllergic(request.allergic());
        entity.setAllergicTo(Boolean.TRUE.equals(request.allergic()) ? request.allergicTo() : "S/A");
        entity.setFootwearType(request.footwearType());
        entity.setFootwearNumber(request.footwearNumber());
        entity.setMainComplaint(request.mainComplaint());
        entity.setLowerLimbSurgery(request.lowerLimbSurgery());
        entity.setSurgeryDetails(request.surgeryDetails());
        entity.setPracticesSports(request.practicesSports());
        entity.setSportType(request.sportType());
        entity.setSportFrequency(request.sportFrequency());
        entity.setSportFootwear(request.sportFootwear());
        entity.setUsesMedication(request.usesMedication());
        entity.setMedicationDetails(request.medicationDetails());
        entity.setPregnant(request.pregnant());
        entity.setPainSensitivity(request.painSensitivity());
        entity.setHypertension(request.hypertension());
        entity.setHeartDisease(request.heartDisease());
        entity.setSeizures(request.seizures());
        entity.setHepatitis(request.hepatitis());
        entity.setKidneyDisease(request.kidneyDisease());
        entity.setHemodialysis(request.hemodialysis());
        entity.setVaricoseVeins(request.varicoseVeins());
        entity.setPeripheralNeuropathy(request.peripheralNeuropathy());
        entity.setSmoker(request.smoker());
        entity.setPsoriasis(request.psoriasis());
        entity.setOncologicalHistory(request.oncologicalHistory());
        entity.setVascularImpairment(request.vascularImpairment());
        entity.setPacemakerOrPins(request.pacemakerOrPins());
    }
}
