package com.podogestao.mapper;

import com.podogestao.controller.request.PodologicalInspectionRequest;
import com.podogestao.controller.response.PodologicalInspectionResponse;
import com.podogestao.entity.PodologicalInspection;
import org.mapstruct.Mapper;
;

@Mapper(componentModel = "spring")
public interface PodologicalInspectionMapper {

    PodologicalInspection toEntity(PodologicalInspectionRequest request);

    PodologicalInspectionResponse toResponse(PodologicalInspection entity);
}

