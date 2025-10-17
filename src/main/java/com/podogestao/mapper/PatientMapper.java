package com.podogestao.mapper;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.Patient;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientRequest request);

    PatientResponse toResponse(Patient patient);
}
