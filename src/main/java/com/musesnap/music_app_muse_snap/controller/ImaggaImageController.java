package com.musesnap.music_app_muse_snap.controller;

import com.musesnap.music_app_muse_snap.service.ImageRecognitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imagga")
public class ImaggaImageController {
    private final ImageRecognitionService recognitionService;

    public ImaggaImageController(ImageRecognitionService recognitionService) {
        this.recognitionService = recognitionService;
    }

    @PostMapping("/recognize")
    public ResponseEntity<String> recognizeImage(@RequestParam("imageUrl") String imageUrl) {
        try {
            String response = recognitionService.recognizeImage(imageUrl);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
