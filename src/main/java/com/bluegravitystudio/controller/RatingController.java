package com.bluegravitystudio.controller;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.entity.Rating;
import com.bluegravitystudio.service.RatingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rating")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/evaluate")
    public ResponseEntity<?> saveRating(@RequestBody @Valid Rating rating) {
        try{
            return ResponseEntity.ok(ratingService.saveRating(rating));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
