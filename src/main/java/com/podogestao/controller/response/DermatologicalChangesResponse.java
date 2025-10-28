package com.podogestao.controller.response;

public record DermatologicalChangesResponse(

        Long id,
        boolean onychomycosis,
        boolean onychophosis,
        boolean onycholysis,
        boolean onychogryphosis,
        boolean granuloma,
        boolean onychocryptosis,
        boolean onychotrophy,
        boolean onychorrhexis,
        boolean nailPsoriasis
) {
}
