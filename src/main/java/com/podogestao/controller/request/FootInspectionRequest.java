package com.podogestao.controller.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.podogestao.enums.FootCondition;
import com.podogestao.enums.FootType;
import com.podogestao.enums.PerfusionType;
import com.podogestao.enums.ToeType;

import java.util.Set;

public record FootInspectionRequest(

        ToeType toeType,
        FootType footType,
        @JsonProperty("perfusion")
        @JsonAlias({"perfusionType"})
        PerfusionType perfusion,
        @JsonProperty("conditions")
        @JsonAlias({"footCondition", "footConditions"})
        @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
        Set<FootCondition> conditions,
        DermatologicalChangesRequest dermatologicalChanges
) {
}
