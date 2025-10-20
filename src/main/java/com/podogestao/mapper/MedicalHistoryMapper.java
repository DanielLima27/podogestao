package com.podogestao.mapper;

import com.podogestao.controller.request.MedicalHistoryRequest;
import com.podogestao.controller.response.MedicalHistoryResponse;
import com.podogestao.entity.MedicalHistory;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {

    MedicalHistory toEntity(MedicalHistoryRequest request);

    MedicalHistoryResponse toResponse(MedicalHistory medicalHistory);
}
