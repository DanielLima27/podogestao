package com.podogestao.controller;


import com.podogestao.controller.request.ProfessionalObservationsRequest;
import com.podogestao.controller.response.ProfessionalObservationsResponse;
import com.podogestao.service.ProfessionalObeservationsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/anamnese/{medicalHistoryId}/observacoes-profissionais")
@RequiredArgsConstructor
public class ProfessionalObservationsController {

    private final ProfessionalObeservationsService service;


    @PostMapping
    public ResponseEntity<ProfessionalObservationsResponse> create(
            @PathVariable Long medicalHistoryId,
            @RequestBody ProfessionalObservationsRequest request
    ) {
        Optional<ProfessionalObservationsResponse> response = service.create(medicalHistoryId, request);
        return response.map(r -> ResponseEntity.status(201).body(r))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<ProfessionalObservationsResponse> findByMedicalHistory(@PathVariable Long medicalHistoryId) {
        Optional<ProfessionalObservationsResponse> response = service.findByMedicalHistory(medicalHistoryId);
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<ProfessionalObservationsResponse> update(
            @PathVariable Long medicalHistoryId,
            @RequestBody ProfessionalObservationsRequest request
    ) {
        Optional<ProfessionalObservationsResponse> response = service.update(medicalHistoryId, request);
        return response.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long medicalHistoryId) {
        boolean deleted = service.delete(medicalHistoryId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

