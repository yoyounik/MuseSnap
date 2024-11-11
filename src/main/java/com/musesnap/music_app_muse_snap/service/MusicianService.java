package com.musesnap.music_app_muse_snap.service;

import com.musesnap.music_app_muse_snap.entity.Musician;
import com.musesnap.music_app_muse_snap.repository.MusicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MusicianService {
    @Autowired
    private MusicianRepository musicianRepository;

    public Musician saveMusician(Musician musician) {
        return musicianRepository.save(musician);
    }

//    public Optional<Musician> getMusicianByName(String name) {
//        return musicianRepository.findByName(name);
//    }

    public List<Musician> getAllMusician() {
        return musicianRepository.findAll();
    }

    // Placeholder for AI recognition logic
    public String recognizeAndRecommendSongs(String imageUrl) {
        // Call AI API and return recommendations
        return "Recommended songs here";
    }
}
