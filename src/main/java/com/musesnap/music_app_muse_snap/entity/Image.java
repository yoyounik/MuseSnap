package com.musesnap.music_app_muse_snap.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "images")
public class Image {
    private String id;
    private String fileName;
    private String contentType;
    private long size;
    private Date uploadDate;
    private byte[] data; // or use Binary type for MongoDB
}
