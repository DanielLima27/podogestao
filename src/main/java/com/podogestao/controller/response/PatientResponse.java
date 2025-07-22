package com.podogestao.controller.response;


import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatientResponse(
        Long id,
        String name,
        String cpf,
        String phone,
        String email,
        LocalDate dateOfBirth,
        String maritalStatus,
        String address,
        String neighborhood,
        String city,
        String zipCode

) {

}