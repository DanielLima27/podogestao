package com.podogestao.controller;

import com.podogestao.controller.request.AnamnesisRequest;
import com.podogestao.controller.response.AnamnesisResponse;
import com.podogestao.entity.Anamnesis;
import com.podogestao.mapper.AnamnesisMapper;
import com.podogestao.service.AnamnesisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/podogestao/anamnesis")
public class AnamnesisController {

    private final AnamnesisService service;
    private final AnamnesisMapper mapper;

    @PostMapping
    public ResponseEntity<AnamnesisResponse> save(@RequestBody AnamnesisRequest request) {
        Anamnesis newAnamnesis = mapper.toAnaminesis(request);
        Anamnesis saved = service.save(newAnamnesis,request.patientId());
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(saved));
    }

    @GetMapping
    public ResponseEntity<List<AnamnesisResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAllAnamnesis()
                        .stream()
                        .map(mapper::toResponse)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnamnesisResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(anamnesis -> ResponseEntity.ok(mapper.toResponse(anamnesis)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnamnesisResponse> update(@PathVariable Long id, @RequestBody AnamnesisRequest request) {
        return service.update(id, mapper.toAnaminesis(request))
                .map(updated -> ResponseEntity.ok(mapper.toResponse(updated)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAnamnesis(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
