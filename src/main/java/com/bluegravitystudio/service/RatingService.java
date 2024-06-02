package com.bluegravitystudio.service;

import com.bluegravitystudio.entity.Rating;
import com.bluegravitystudio.repository.MediaRepository;
import com.bluegravitystudio.repository.RatingRepository;
import com.bluegravitystudio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MediaRepository mediaRepository;

    public Rating saveRating(Rating rating) throws Exception {
        if(userRepository.findById(rating.getUserId()).isPresent() &&
                mediaRepository.findById(rating.getMediaId()).isPresent()){
            return ratingRepository.save(rating);
        }

        throw new Exception("invalid rating");
    }

}
