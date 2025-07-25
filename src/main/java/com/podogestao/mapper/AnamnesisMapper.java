package com.podogestao.mapper;

import com.podogestao.controller.request.AnamnesisRequest;
import com.podogestao.controller.response.AnamnesisResponse;
import com.podogestao.entity.Anamnesis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnamnesisMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Anamnesis toAnaminesis(AnamnesisRequest request);

    @Mapping(target = "patientId", source = "patient.id")
    AnamnesisResponse toResponse(Anamnesis anamnesis);
}