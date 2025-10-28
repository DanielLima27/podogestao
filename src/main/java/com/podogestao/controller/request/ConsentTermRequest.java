package com.podogestao.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ConsentTermRequest(

        String patientName,
        String cpf,
        String procedure,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate agreementDate,
        String clientSignature
) {
}
