package com.musesnap.music_app_muse_snap.controller;

import com.musesnap.music_app_muse_snap.entity.Musician;
import com.musesnap.music_app_muse_snap.service.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musician")
public class MusicianController {
    @Autowired
    private MusicianService musicianService;

    @PostMapping
    public Musician createMusician(@RequestBody Musician musician){
        return musicianService.saveMusician(musician);
    }

    @GetMapping
    public List<Musician> getMusician(){
        return  musicianService.getAllMusician();
    }

    public String name(){
        return "Nikhil";
    }


}
