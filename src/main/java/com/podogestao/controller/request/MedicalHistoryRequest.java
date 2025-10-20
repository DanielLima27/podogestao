package com.podogestao.controller.request;

public record MedicalHistoryRequest(

        Boolean allergic,
        String allergicTo,
        String footwearType,
        String footwearNumber,
        String mainComplaint,
        Boolean lowerLimbSurgery,
        String surgeryDetails,
        Boolean practicesSports,
        String sportType,
        String sportFrequency,
        String sportFootwear,
        Boolean usesMedication,
        String medicationDetails,
        Boolean pregnant,
        String painSensitivity,
        Boolean hypertension,
        Boolean heartDisease,
        Boolean seizures,
        Boolean hepatitis,
        Boolean kidneyDisease,
        Boolean hemodialysis,
        Boolean varicoseVeins,
        Boolean peripheralNeuropathy,
        Boolean smoker,
        Boolean psoriasis,
        Boolean oncologicalHistory,
        Boolean vascularImpairment,
        Boolean pacemakerOrPins
) {
}
