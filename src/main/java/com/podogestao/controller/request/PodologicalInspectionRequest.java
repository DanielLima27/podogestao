package com.podogestao.controller.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PodologicalInspectionRequest(

        @JsonProperty("rightFoot")
        @JsonAlias({"rightFootInspection"})
        FootInspectionRequest rightFoot,

        @JsonProperty("leftFoot")
        @JsonAlias({"leftFootInspection"})
        FootInspectionRequest leftFoot
) {
}
