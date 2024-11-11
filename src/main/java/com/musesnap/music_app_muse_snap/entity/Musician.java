package com.musesnap.music_app_muse_snap.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "musicians")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Musician {
    @Id
    private String id;
    private String name;
    private String genre;
    private String bio;
    private List<String> topTracks;
    private byte[] image; // Store raw image data or a URL reference
}
