package com.podogestao.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record ProfessionalObservationsRequest(
        String observationNotes,
        String procedure,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,
        String podologistName,
        PodologicalInspectionRequest podologicalInspection,
        ConsentTermRequest consentTerm
) {
}
