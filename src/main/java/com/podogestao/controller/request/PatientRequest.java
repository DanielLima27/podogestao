package com.podogestao.controller.request;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record PatientRequest(
        String name,
        String cpf,
        String phone,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        LocalDate dateOfBirth,
        String maritalStatus,
        String occupation,
        String address,
        String neighborhood,
        String city,
        String zipCode

) {

}
