package com.podogestao.mapper;

import com.podogestao.controller.request.ProfessionalObservationsRequest;
import com.podogestao.controller.response.ProfessionalObservationsResponse;
import com.podogestao.entity.ProfessionalObservations;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {
        PodologicalInspectionMapper.class,
        ConsentTermMapper.class
})
public interface ProfessionalObservationsMapper {

    ProfessionalObservations toEntity(ProfessionalObservationsRequest request);

    ProfessionalObservationsResponse toResponse(ProfessionalObservations entity);
}

