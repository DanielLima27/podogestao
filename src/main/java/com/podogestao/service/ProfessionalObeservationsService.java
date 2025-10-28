package com.podogestao.service;


import com.podogestao.controller.request.ProfessionalObservationsRequest;
import com.podogestao.controller.response.ProfessionalObservationsResponse;
import com.podogestao.entity.MedicalHistory;
import com.podogestao.entity.ProfessionalObservations;
import com.podogestao.mapper.ProfessionalObservationsMapper;
import com.podogestao.repository.MedicalHistoryRepository;
import com.podogestao.repository.ProfessionalObservationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalObeservationsService {

    private final MedicalHistoryRepository medicalHistoryRepository;
    private final ProfessionalObservationsRepository repository;
    private final ProfessionalObservationsMapper mapper;



    public Optional<ProfessionalObservationsResponse> create(Long medicalHistoryId, ProfessionalObservationsRequest request) {
        var historyOpt = medicalHistoryRepository.findById(medicalHistoryId);

        if (historyOpt.isEmpty()) {
            return Optional.empty();
        }

        var history = historyOpt.get();
        var entity = mapper.toEntity(request);

        var savedObservation = repository.save(entity);

        history.setProfessionalObservations(savedObservation);
        medicalHistoryRepository.save(history);

        return Optional.of(mapper.toResponse(savedObservation));
    }



    public Optional<ProfessionalObservationsResponse> findByMedicalHistory(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId)
                .map(MedicalHistory::getProfessionalObservations)
                .map(mapper::toResponse);
    }


    public Optional<ProfessionalObservationsResponse> update(Long medicalHistoryId, ProfessionalObservationsRequest request) {
        return medicalHistoryRepository.findById(medicalHistoryId)
                .map(history -> {
                    ProfessionalObservations existing = history.getProfessionalObservations();
                    if (existing == null) {
                        ProfessionalObservations newEntity = mapper.toEntity(request);
                        repository.save(newEntity);
                        history.setProfessionalObservations(newEntity);
                    } else {
                        ProfessionalObservations updated = mapper.toEntity(request);
                        updated.setId(existing.getId());
                        repository.save(updated);
                        history.setProfessionalObservations(updated);
                    }
                    medicalHistoryRepository.save(history);
                    return mapper.toResponse(history.getProfessionalObservations());
                });
    }


    public boolean delete(Long medicalHistoryId) {
        return medicalHistoryRepository.findById(medicalHistoryId)
                .map(history -> {
                    ProfessionalObservations obs = history.getProfessionalObservations();
                    if (obs != null) {
                        history.setProfessionalObservations(null);
                        medicalHistoryRepository.save(history);
                        repository.delete(obs);
                        return true;
                    }
                    return false;
                }).orElse(false);
    }

}
