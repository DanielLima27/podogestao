package com.podogestao.controller.response;

import lombok.Builder;

@Builder
public record AnamnesisResponse(
        Long id,
        Long patientId,
        Boolean isAllergic,
        String allergy,
        String footwearType,
        Integer footwearSize,
        String complaint,
        Boolean hasSurgery,
        String surgeryDetails,
        Boolean playsSports,
        String sport,
        String frequency,
        String sportFootwear,
        Boolean takesMedication,
        String medication,
        Boolean pregnant,
        String painSensitivity,
        Boolean hypertension,
        Boolean heartCondition,
        Boolean seizures,
        Boolean hepatitis,
        Boolean nephropathy,
        Boolean dialysis,
        Boolean varicoseVeins,
        Boolean neuropathy,
        Boolean smoker,
        Boolean psoriasis,
        Boolean cancerHistory,
        Boolean vascularIssue,
        Boolean pacemaker

) {
}
