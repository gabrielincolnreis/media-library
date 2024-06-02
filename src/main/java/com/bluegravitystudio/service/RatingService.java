package com.bluegravitystudio.service;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.entity.Rating;
import com.bluegravitystudio.entity.User;
import com.bluegravitystudio.repository.MediaRepository;
import com.bluegravitystudio.repository.RatingRepository;
import com.bluegravitystudio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MediaRepository mediaRepository;

    public Rating saveRating(Rating rating) throws Exception {
        Optional<Media> media = mediaRepository.findById(rating.getMediaId());
        Optional<User> user = userRepository.findById(rating.getUserId());
        //TODO: Take the user by JWT token

        if(user.isPresent() && media.isPresent()){
            return ratingRepository.save(rating);
        }

        throw new Exception("invalid rating");
    }

}
