package com.example.dao;

import com.example.dto.RatingDTO;

public interface RatingDAO {
    boolean saveOrUpdateRating(RatingDTO rating);
    RatingDTO getUserRating(int userId, int movieId);
}
