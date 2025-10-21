package com.podogestao.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PatientRequest(

    String name,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate birthDate,
    String address,
    String neighborhood,
    String city,
    String zipCode,
    String maritalStatus,
    String email,
    String phone,
    String occupation,
    MedicalHistoryRequest medicalHistory
) {
}
