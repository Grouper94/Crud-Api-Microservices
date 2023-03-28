package com.example.ratinginfoservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

@Entity
@Setter
@Getter
@Table(name = "ratings")
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    public Rating (Integer userId, Integer productId, Integer productRating)  {
        this.userId = userId ;
        this.productId = productId ;
        this.productRating = productRating ;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Integer ratingId ;

    @Column(name = "product_rating")
    private Integer productRating ;

    @JoinColumn (name = "user_id")

    private Integer userId ;

    @JoinColumn (name = "product_id")
    private Integer productId ;



}
