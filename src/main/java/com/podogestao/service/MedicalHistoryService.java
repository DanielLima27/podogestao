package com.podogestao.service;


import com.podogestao.controller.request.MedicalHistoryRequest;
import com.podogestao.controller.response.MedicalHistoryResponse;
import com.podogestao.entity.MedicalHistory;
import com.podogestao.mapper.MedicalHistoryMapper;
import com.podogestao.repository.MedicalHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {


    private final MedicalHistoryRepository repository;
    private final MedicalHistoryMapper mapper;


    public MedicalHistoryResponse create(MedicalHistoryRequest request) {
        MedicalHistory medicalHistory = mapper.toEntity(request);
        medicalHistory.setAllergicTo(Boolean.TRUE.equals(request.allergic())
                ? request.allergicTo()
                : "S/A");
        repository.save(medicalHistory);
        return mapper.toResponse(medicalHistory);
    }

    public List<MedicalHistoryResponse> findAllMedicalHistories() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Optional<MedicalHistoryResponse> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse);
    }

    public Optional<MedicalHistoryResponse> update(Long id, MedicalHistoryRequest request) {
        return repository.findById(id)
                .map(history -> {
                    mapper.updateEntity(request, history);
                    repository.save(history);
                    return mapper.toResponse(history);
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
