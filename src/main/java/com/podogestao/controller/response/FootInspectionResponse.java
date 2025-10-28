package com.podogestao.controller.response;

import com.podogestao.enums.FootCondition;
import com.podogestao.enums.FootType;
import com.podogestao.enums.PerfusionType;
import com.podogestao.enums.ToeType;

import java.util.Set;

public record FootInspectionResponse(

        Long id,
        ToeType toeType,
        FootType footType,
        PerfusionType perfusion,
        Set<FootCondition> conditions,
        DermatologicalChangesResponse dermatologicalChanges
) {
}
