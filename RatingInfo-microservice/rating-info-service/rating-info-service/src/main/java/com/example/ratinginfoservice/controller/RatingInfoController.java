package com.example.ratinginfoservice.controller;

import com.example.ratinginfoservice.models.Rating;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RatingInfoController {


    Rating addRating (Rating rating) ;

    ResponseEntity<Rating> updateRating(Integer userId, Integer productId, Integer rating) ;



    List<Rating> getAllRatings () ;

    Boolean deleteRatesByUserId(Integer userId) ;

    Optional < List<Rating> > getRatingsByUserId(Integer userId) ;

   // ResponseEntity<List<Rating>> getRatingsByProductId(Integer userId) ;





}
