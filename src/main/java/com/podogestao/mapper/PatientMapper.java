package com.podogestao.mapper;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.MedicalHistory;
import com.podogestao.entity.Patient;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {MedicalHistoryMapper.class})
public interface PatientMapper {

    Patient toEntity(PatientRequest request);

    PatientResponse toResponse(Patient patient);

    default Patient toEntityWithHistory(PatientRequest request) {
        Patient patient = toEntity(request);

        if (patient.getMedicalHistory() != null) {
            patient.getMedicalHistory().setPatient(patient);
        }

        return patient;
    }

    default void updateEntity(PatientRequest request, Patient patient, MedicalHistoryMapper historyMapper) {
        if (request == null || patient == null) return;

        patient.setName(request.name());
        patient.setBirthDate(request.birthDate());
        patient.setAddress(request.address());
        patient.setNeighborhood(request.neighborhood());
        patient.setCity(request.city());
        patient.setZipCode(request.zipCode());
        patient.setMaritalStatus(request.maritalStatus());
        patient.setPhone(request.phone());
        patient.setEmail(request.email());
        patient.setOccupation(request.occupation());

        if (request.medicalHistory() != null) {
            if (patient.getMedicalHistory() == null) {
                MedicalHistory history = historyMapper.toEntity(request.medicalHistory());
                history.setPatient(patient);
                patient.setMedicalHistory(history);
            } else {
                historyMapper.updateEntity(request.medicalHistory(), patient.getMedicalHistory());
            }
        }
    }
}
