package com.podogestao.mapper;

import com.podogestao.controller.request.DermatologicalChangesRequest;
import com.podogestao.controller.response.DermatologicalChangesResponse;
import com.podogestao.entity.DermatologicalChanges;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DermatologicalChangesMapper {

    DermatologicalChanges toEntity(DermatologicalChangesRequest request);

    DermatologicalChangesResponse toResponse(DermatologicalChanges entity);
}
