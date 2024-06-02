package com.bluegravitystudio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ratingId;
    @NotNull
    private Long userId;
    @NotNull
    private Long mediaId;

    @Max(value = 5, message = "must be less than 5")
    @NotNull
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
