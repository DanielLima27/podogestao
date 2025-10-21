package com.podogestao.service;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.Patient;
import com.podogestao.mapper.MedicalHistoryMapper;
import com.podogestao.mapper.PatientMapper;
import com.podogestao.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;
    private final MedicalHistoryMapper historyMapper;



    public PatientResponse create(PatientRequest request) {
        Patient patient = mapper.toEntityWithHistory(request);
        Patient saved = repository.save(patient);
        return mapper.toResponse(saved);
    }

    public List<PatientResponse> findAllPatients() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }


    public Optional<PatientResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    public Optional<PatientResponse> update(Long id, PatientRequest request) {
        return repository.findById(id)
                .map(existing -> {
                    mapper.updateEntity(request, existing, historyMapper);
                    Patient updated = repository.save(existing);
                    return mapper.toResponse(updated);
                });
    }


    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
