package com.bluegravitystudio.controller;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.entity.Rating;
import com.bluegravitystudio.service.MediaService;
import com.bluegravitystudio.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MediaService mediaService;

    @PostMapping("/evaluate")
    public ResponseEntity<?> saveRating(@Valid @RequestBody Rating rating) {
        try{
            Rating savedRating = ratingService.saveRating(rating);
            mediaService.updateMediaRating(rating.getMediaId());
            return ResponseEntity.ok(savedRating);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
