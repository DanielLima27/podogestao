package com.podogestao.controller;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.Patient;
import com.podogestao.mapper.PatientMapper;
import com.podogestao.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService service;
    private final PatientMapper mapper;



    @PostMapping("/cadastro")
    public ResponseEntity<PatientResponse> create(@RequestBody PatientRequest request) {
        PatientResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


    @GetMapping("/listar")
    public ResponseEntity<List<PatientResponse>> getAll() {
        List<PatientResponse> patients = service.findAllPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable Long id, @RequestBody PatientRequest request) {
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
