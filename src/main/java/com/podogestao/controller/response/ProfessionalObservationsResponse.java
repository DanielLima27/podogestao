package com.podogestao.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ProfessionalObservationsResponse(

        Long id,
        String observationNotes,
        String procedure,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,
        String podologistName,
        PodologicalInspectionResponse podologicalInspection,
        ConsentTermResponse consentTerm
) {
}
