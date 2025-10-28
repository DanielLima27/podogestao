package com.podogestao.controller.request;

public record DermatologicalChangesRequest(

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
