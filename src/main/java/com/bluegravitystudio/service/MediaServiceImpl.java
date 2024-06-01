package com.bluegravitystudio.service;

import com.bluegravitystudio.entity.Media;
import com.bluegravitystudio.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService{

    @Autowired
    private MediaRepository mediaRepository;
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
            mediaRepository.save(mediaFounded);
            return mediaFounded;
        }
        throw new Exception("Media not found");

    }

    @Override
    public void deleteMediaById(Long mediaId) throws Exception {

        if(mediaRepository.findById(mediaId).isPresent()){
            mediaRepository.deleteById(mediaId);
        }
        throw new Exception("Media not found");
    }
}
