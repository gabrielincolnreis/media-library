package com.bluegravitystudio.service;

import com.bluegravitystudio.entity.Media;

import java.util.List;

public interface MediaService {
    Media saveMedia(Media media);

    List<Media> mediaList();

    Media updateMedia(Media media, Long mediaId) throws Exception;

    void deleteMediaById(Long mediaId) throws Exception;

    Media updateMediaRating(Long mediaId) throws Exception;

}
