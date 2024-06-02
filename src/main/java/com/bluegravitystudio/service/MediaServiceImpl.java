package com.bluegravitystudio.service;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.entity.Rating;
import com.bluegravitystudio.repository.MediaRepository;
import com.bluegravitystudio.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MediaServiceImpl implements MediaService{

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public List<Media> mediaList() {
        return (List<Media>) mediaRepository.findAll();
    }

    @Override
    public Media updateMedia(Media media, Long mediaId) throws Exception {

        if(mediaRepository.findById(mediaId).isPresent()){
            Media mediaFounded  = mediaRepository.findById(mediaId).get();

            if(Objects.nonNull(media.getTitle())){{
                mediaFounded.setTitle(media.getTitle());
            }}

            if(Objects.nonNull(media.getDescription())){{
                mediaFounded.setDescription(media.getDescription());
            }}

            if(Objects.nonNull(media.getCategory())){{
                mediaFounded.setCategory(media.getCategory());
            }}

            if(Objects.nonNull(media.getThumbnail_url())){{
                mediaFounded.setThumbnail_url(media.getThumbnail_url());
            }}

            if(Objects.nonNull(media.getContent_url())){{
                mediaFounded.setContent_url(media.getContent_url());
            }}

            if(Objects.nonNull(media.getCreated_at())){{
                mediaFounded.setCreated_at(media.getCreated_at());
            }}

            mediaRepository.save(mediaFounded);
            return media;
        } else{
            throw new Exception("Media not found");
        }


    }

    @Override
    public void deleteMediaById(Long mediaId) throws Exception {

        if(mediaRepository.findById(mediaId).isPresent()){
            mediaRepository.deleteById(mediaId);
        }else {
            throw new Exception("Media not found");
        }

    }

    public Media updateMediaRating(Long mediaId) throws Exception {

        if(mediaRepository.findById(mediaId).isPresent()){
            List<Rating> ratings =  ratingRepository.findAllByMediaId(mediaId);
            Long average = 0L;
            int count = 0;
            for(Rating rating : ratings){
                if(Objects.nonNull(rating.getRating())){
                    average = rating.getRating() + average;
                    count = count + 1;
                }
            }

            Media mediaFounded  = mediaRepository.findById(mediaId).get();
            mediaFounded.setRating(average/count);
            mediaRepository.save(mediaFounded);
            return mediaFounded;
        } else {
            throw new Exception("Media not found");
        }

    }
}
