package com.example.ratinginfoservice.service;

import com.example.ratinginfoservice.models.Rating;
import com.example.ratinginfoservice.repository.RatingInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RatingInfoServiceImpl implements  RatingInfoService {

    RatingInfoRepository ratingInfoRepository;

    public RatingInfoServiceImpl(RatingInfoRepository ratingInfoRepository) {
        this.ratingInfoRepository = ratingInfoRepository;
    }

    @Override
    public Rating addRating(Rating rating) {

        if (ratingInfoRepository.checkDuplicates(rating.getUserId(), rating.getProductId())) {
            return new Rating();
        } else {
            return ratingInfoRepository.save(rating);
        }
    }

    @Override
    public Rating updateRating(Rating rating) {
        if (ratingInfoRepository.checkDuplicates(rating.getUserId(), rating.getProductId()))
            return ratingInfoRepository.save(rating);
        return new Rating();
    }


    @Override
    public Optional<List<Rating>> getRatingsByUserId(Integer userId) {
        return ratingInfoRepository.findAllByUserId(userId) ;
    }

    @Override
    public List<Rating> getAllRatings () {
        return  ratingInfoRepository.findAll() ;
    }

    @Override
    public Boolean deleteRatesByUserId(Integer userId) {

        ratingInfoRepository.deleteRatesByUserId(userId) ;
        return !ratingInfoRepository.existsById(userId);

    }

}




