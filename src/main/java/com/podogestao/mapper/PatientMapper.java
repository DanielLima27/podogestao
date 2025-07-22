package com.podogestao.mapper;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "cpf", source = "cpf")
    Patient toPaciente(PatientRequest request);

    PatientResponse toResponse(Patient patient);
}