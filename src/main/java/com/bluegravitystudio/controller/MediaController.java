package com.bluegravitystudio.controller;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/media")
public class MediaController{

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping("/create")
    public ResponseEntity<Media> saveMedia(@Valid @RequestBody Media media){
        return ResponseEntity.ok(mediaService.saveMedia(media));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Media>> mediaList() {
        return ResponseEntity.ok(mediaService.mediaList());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Media> updateMedia(@RequestBody Media media, @PathVariable("id") Long mediaId) {
        try{
            return ResponseEntity.ok(mediaService.updateMedia(media, mediaId));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMediaById(@PathVariable("id") Long mediaId) {

        try{
            mediaService.deleteMediaById(mediaId);
            return  ResponseEntity.ok("Deleted Successfully");
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

