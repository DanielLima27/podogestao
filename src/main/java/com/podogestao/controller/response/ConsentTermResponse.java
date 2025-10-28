package com.podogestao.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ConsentTermResponse(

        Long id,
        String patientName,
        String cpf,
        String procedure,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate agreementDate,
        String clientSignature
) {
}
