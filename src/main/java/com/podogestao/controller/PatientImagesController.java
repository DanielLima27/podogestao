package com.podogestao.controller;



import com.podogestao.controller.response.PatientImagesResponse;
import com.podogestao.service.PatientImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/patients/{patientId}/images")
@RequiredArgsConstructor
public class PatientImagesController {

    private final PatientImagesService imageService;

    @PostMapping("/upload")
    public ResponseEntity<PatientImagesResponse> uploadImage(
            @PathVariable Long patientId,
            @RequestParam("file") MultipartFile file) {

        try {
            PatientImagesResponse response = imageService.uploadImage(patientId, file);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PatientImagesResponse>> listImages(@PathVariable Long patientId) {
        List<PatientImagesResponse> images = imageService.listImages(patientId);
        return ResponseEntity.ok(images);
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long imageId) throws IOException {
        byte[] imageData = imageService.getImage(imageId);
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg")
                .body(imageData);
    }

    @DeleteMapping("/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Long imageId) {
        try {
            String message = imageService.deleteImage(imageId);
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}