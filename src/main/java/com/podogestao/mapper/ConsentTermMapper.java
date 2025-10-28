package com.podogestao.mapper;

import com.podogestao.controller.request.ConsentTermRequest;
import com.podogestao.controller.response.ConsentTermResponse;
import com.podogestao.entity.ConsentTerm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConsentTermMapper {

    ConsentTerm toEntity(ConsentTermRequest request);

    ConsentTermResponse toResponse(ConsentTerm entity);
}
