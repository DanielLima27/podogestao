package com.podogestao.controller;


import com.podogestao.controller.request.MedicalHistoryRequest;
import com.podogestao.controller.response.MedicalHistoryResponse;
import com.podogestao.mapper.MedicalHistoryMapper;
import com.podogestao.service.MedicalHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anamnese")
@RequiredArgsConstructor
public class MedicalHistoryController {

    private final MedicalHistoryService service;
    private final MedicalHistoryMapper mapper;


    @PostMapping("/cadastro")
    public ResponseEntity<MedicalHistoryResponse> create(@RequestBody MedicalHistoryRequest request) {
        MedicalHistoryResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<MedicalHistoryResponse>> getAll() {
        List<MedicalHistoryResponse> patients = service.findAllMedicalHistories();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalHistoryResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalHistoryResponse> update(@PathVariable Long id, @RequestBody MedicalHistoryRequest request) {
        return service.update(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }



}
