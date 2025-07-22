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

@RequiredArgsConstructor
@RestController
@RequestMapping("/podogestao")
public class PatientController {

    private final PatientService service;
    private final PatientMapper mapper;


    @PostMapping()
    public ResponseEntity<PatientResponse> savePatient (@RequestBody PatientRequest request){
        Patient newPatient = mapper.toPaciente(request);
        Patient patientSave = service.savePatiente(newPatient);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(patientSave));
    }

    @GetMapping()
    public ResponseEntity<List<PatientResponse>>listarPacientes(){
        return ResponseEntity.ok(service.findAllPatient()
                .stream()
                .map(mapper::toResponse)
                .toList()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id){
        return service.findById(id)
                .map(patient -> ResponseEntity.ok(mapper.toResponse(patient)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable Long id, @RequestBody PatientRequest request){
        return service.update(id, mapper.toPaciente(request))
                .map(patient -> ResponseEntity.ok(mapper.toResponse(patient)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacienteById(@PathVariable Long id){
        service.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }



}