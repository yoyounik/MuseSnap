package com.musesnap.music_app_muse_snap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import java.io.IOException;

@RestController
@RequestMapping("/api/uploads")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://musesnap.vercel.app",
    "https://musesnap1.vercel.app",
    "https://musesnap-9m7jhqjlw-nikhils-projects-63d23fe7.vercel.app"
})
public class ImageUploadController {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    // Endpoint to upload an image
    @PostMapping("/images")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Save the file to MongoDB GridFS
            ObjectId fileId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
            return ResponseEntity.ok("Image uploaded successfully with ID: " + fileId.toString());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

    // Endpoint to retrieve an image by ID
    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
        try {
            // Find the file in GridFS
            GridFSFile gridFSFile = gridFsTemplate.findOne(
                    new org.springframework.data.mongodb.core.query.Query()
                            .addCriteria(org.springframework.data.mongodb.core.query.Criteria.where("_id").is(new ObjectId(id)))
            );

            if (gridFSFile != null) {
                // Get the resource from GridFS
                GridFsResource resource = gridFsTemplate.getResource(gridFSFile);
                byte[] data = resource.getInputStream().readAllBytes();

                // Use the content type from GridFS file metadata or a default value
                String contentType = resource.getContentType() != null ? resource.getContentType() : "application/octet-stream";
                return ResponseEntity.ok()
                        .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
                        .body(data);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

