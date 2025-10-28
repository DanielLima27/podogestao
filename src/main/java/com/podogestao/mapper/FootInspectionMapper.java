package com.podogestao.mapper;

import com.podogestao.controller.request.FootInspectionRequest;
import com.podogestao.controller.response.FootInspectionResponse;
import com.podogestao.entity.FootInspection;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FootInspectionMapper {

    FootInspection toEntity(FootInspectionRequest request);
    FootInspectionResponse toResponse(FootInspection entity);
}

