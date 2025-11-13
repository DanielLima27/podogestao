package com.podogestao.service;

import com.podogestao.controller.request.PatientImagesRequest;
import com.podogestao.controller.response.PatientImagesResponse;
import com.podogestao.entity.Patient;
import com.podogestao.entity.PatientImages;
import com.podogestao.repository.PatientImageRepository;
import com.podogestao.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientImagesService {

    private final PatientImageRepository imageRepository;
    private final PatientRepository patientRepository;

    @Value("${upload.directory}")
    private String uploadDir;

    public PatientImagesResponse uploadImage(Long patientId, MultipartFile file) throws IOException {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        String folder = uploadDir + "/" + patient.getId();
        Files.createDirectories(Paths.get(folder));

        Path filePath = Paths.get(folder, file.getOriginalFilename());
        file.transferTo(filePath.toFile());

        PatientImages image = new PatientImages();
        image.setPatient(patient);
        image.setFileName(file.getOriginalFilename());
        image.setFilePath(filePath.toString());

        PatientImages saved = imageRepository.save(image);

        return new PatientImagesResponse(
                saved.getId(),
                saved.getPatient().getId(),
                saved.getFileName(),
                saved.getFilePath(),
                saved.getUploadDate()
        );
    }

    public List<PatientImagesResponse> listImages(Long patientId) {
        return imageRepository.findByPatientId(patientId).stream()
                .map(img -> new PatientImagesResponse(
                        img.getId(),
                        img.getPatient().getId(),
                        img.getFileName(),
                        img.getFilePath(),
                        img.getUploadDate()
                ))
                .toList();
    }

    public byte[] getImage(Long imageId) throws IOException {
        PatientImages image = imageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));
        return Files.readAllBytes(Paths.get(image.getFilePath()));
    }

    public String deleteImage(Long imageId) {
        PatientImages image = imageRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Imagem não encontrada"));

        try {
            Files.deleteIfExists(Paths.get(image.getFilePath()));
            imageRepository.delete(image);
            return "Imagem deletada com sucesso!";
        } catch (IOException e) {
            throw new RuntimeException("Erro ao deletar imagem: " + e.getMessage());
        }
    }
}
