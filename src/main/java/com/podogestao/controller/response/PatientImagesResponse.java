package com.podogestao.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


public record PatientImagesResponse(
        Long id,
        Long patientId,
        String fileName,
        String filePath,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        LocalDateTime uploadDate
) {}