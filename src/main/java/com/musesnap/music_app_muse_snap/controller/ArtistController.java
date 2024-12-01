package com.musesnap.music_app_muse_snap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ArtistController {
    private final RestTemplate restTemplate;

    public ArtistController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/search/artist")
    public ResponseEntity<?> searchArtist(@RequestParam String name) {
        try {
            String apiUrl = "https://api.deezer.com/search/artist?q=" + name;
            String response = restTemplate.getForObject(apiUrl, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to fetch artist data");
        }
    }
}
