package com.example.ratinginfoservice.controller;

import com.example.ratinginfoservice.models.Rating;
import com.example.ratinginfoservice.service.RatingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/Ratings")
public class RatingInfoControllerImpl implements  RatingInfoController {
    RatingInfoService ratingInfoService ;

    @Autowired
    public RatingInfoControllerImpl(RatingInfoService ratingInfoService) {
        this.ratingInfoService = ratingInfoService ;
    }

    @Override
    @PostMapping("/create-rating")
    public Rating addRating (@RequestBody Rating rating) {
        //System.out.println(rating.getProductRating());
        return ratingInfoService.addRating(rating) ;
    }


    @Override
    @PutMapping("/update-rating")
    public ResponseEntity<Rating> updateRating (@RequestParam  Integer userId,@RequestParam Integer productId,@RequestParam Integer productRating) {
        Rating rating = new Rating(userId,productId,productRating);
        return new ResponseEntity<>(ratingInfoService.updateRating(rating),HttpStatus.OK);
    }

    @Override
    @GetMapping("/get-ratings-userId/{userId}")
    public Optional< List<Rating> > getRatingsByUserId(@PathVariable  Integer userId) {
       return ratingInfoService.getRatingsByUserId(userId) ;
  }

  @Override
  @GetMapping("get-all-ratings")
  public List<Rating> getAllRatings () {
        return ratingInfoService.getAllRatings() ;
  }

  @Override
  @DeleteMapping("delete-ratingByUserId/{userId}")
  public Boolean deleteRatesByUserId(@PathVariable  Integer userId) {
        return ratingInfoService.deleteRatesByUserId(userId) ;
  }

}
