package com.podogestao.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

public record PatientResponse(

    Long id,
    String name,
        @JsonFormat(pattern = "dd/MM/yyyy")
    String birthDate,
    String address,
    String neighborhood,
    String city,
    String zipCode,
    String maritalStatus,
    String email,
    String phone,
    String occupation,
    MedicalHistoryResponse medicalHistory

) {
}
