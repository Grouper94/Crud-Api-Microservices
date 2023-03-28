package com.example.ratinginfoservice.repository;

import com.example.ratinginfoservice.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RatingInfoRepository extends JpaRepository<Rating,Integer > {

    Rating save(Rating rating) ;


    @Query ("SELECT CASE  WHEN count(r) > 0 THEN true ELSE false END FROM Rating r  WHERE r.userId = ?1 AND r.productId = ?2  ")
        //("SELECT  r FROM Rating r WHERE r.userId = ?1 AND r.productId = ?2" )
    Boolean checkDuplicates (Integer userId,Integer productId );

    Optional<List<Rating>> findAllByUserId(Integer user_id) ;

    List<Rating> findAll() ;

    //("SELECT  r FROM Rating r WHERE r.userId = ?1 AND r.productId = ?2" )
    //@Query ("DELETE r FROM Rating r WHERE r,userId = ?1 )
    //@Query ("DELETE CASE  WHEN count(r) > 0 THEN true ELSE false END FROM Rating r  WHERE r.userId = ?1")
    void deleteRatesByUserId(Integer userId) ;






}
