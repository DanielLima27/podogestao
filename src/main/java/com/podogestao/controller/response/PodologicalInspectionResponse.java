package com.podogestao.controller.response;

public record PodologicalInspectionResponse(

        Long id,
        FootInspectionResponse rightFoot,
        FootInspectionResponse leftFoot
) {
}
