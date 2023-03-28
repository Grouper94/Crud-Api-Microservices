package com.example.ratinginfoservice.service;

import com.example.ratinginfoservice.models.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RatingInfoService {
    Rating addRating(Rating rating);

    Rating updateRating(Rating rating) ;

   Optional <List<Rating>> getRatingsByUserId(Integer userId) ;

   List<Rating> getAllRatings ();

   Boolean deleteRatesByUserId(Integer userId) ;







}
