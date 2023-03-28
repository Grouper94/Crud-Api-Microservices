package com.example.productcatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    public Rating (Integer userId,Integer productId,Integer productRating) {
        this.userId = userId ;
        this.productId = productId ;
        this.productRating = productRating ;
    }

    private Integer ratingId ;

    private Integer userId ;

    private Integer productId ;

    private Integer productRating ;

}
