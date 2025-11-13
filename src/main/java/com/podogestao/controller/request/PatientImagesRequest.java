package com.podogestao.controller.request;


import com.fasterxml.jackson.annotation.JsonFormat;

public record PatientImagesRequest(

     Long patientId
) {
}
