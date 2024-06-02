package com.bluegravitystudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    @NotBlank
    private Long userId;
    @NotBlank
    private Long mediaId;

    @Max(10)
    @NotBlank
    private Long rating;

    public Rating() {
    }

    public Rating(Long userId, Long mediaId, Long rating) {
        this.userId = userId;
        this.mediaId = mediaId;
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
