package com.podogestao.service;

import com.podogestao.entity.Patient;
import com.podogestao.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repository;

    public Patient savePatiente(Patient patient){
        return repository.save(patient);
    }

    public List<Patient> findAllPatient(){
        return repository.findAll();
    }
    public Optional<Patient> findById (Long id){
        return repository.findById(id);
    }

    public Optional<Patient> update (Long id, Patient updatePatient){
        Optional<Patient> optPatient = repository.findById(id);
        if(optPatient.isPresent()){
            Patient patient = optPatient.get();
            patient.setName(updatePatient.getName());
            patient.setCpf(updatePatient.getCpf());
            patient.setPhone(updatePatient.getPhone());
            patient.setEmail(updatePatient.getEmail());
            patient.setDateOfBirth(updatePatient.getDateOfBirth());
            patient.setMaritalStatus(updatePatient.getMaritalStatus());
            patient.setOccupation(updatePatient.getOccupation());
            patient.setAddress(updatePatient.getAddress());
            patient.setNeighborhood(updatePatient.getNeighborhood());
            patient.setCity(updatePatient.getCity());
            patient.setZipCode(updatePatient.getZipCode());

            repository.save(patient);
            return Optional.of(patient);
        }

        return Optional.empty();
    }

    public void deletePatient(Long id){
        repository.deleteById(id);
    }

}