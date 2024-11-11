package com.musesnap.music_app_muse_snap.repository;

import com.musesnap.music_app_muse_snap.entity.Musician;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MusicianRepository extends MongoRepository<Musician, String> {
    Optional<Musician> findByName(String name);
}
