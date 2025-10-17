package com.podogestao.service;

import com.podogestao.controller.request.PatientRequest;
import com.podogestao.controller.response.PatientResponse;
import com.podogestao.entity.Patient;
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



    public PatientResponse create(PatientRequest request) {
        Patient patient = mapper.toEntity(request);
        repository.save(patient);
        return mapper.toResponse(patient);
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
                .map(patient -> {
                    patient.setName(request.name());
                    patient.setBirthDate(request.birthDate());
                    patient.setAddress(request.address());
                    patient.setNeighborhood(request.neighborhood());
                    patient.setCity(request.city());
                    patient.setZipCode(request.zipCode());
                    patient.setMaritalStatus(request.maritalStatus());
                    patient.setPhone(request.phone());
                    patient.setEmail(request.email());
                    patient.setOccupation(request.occupation());

                    repository.save(patient);
                    return mapper.toResponse(patient);
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
