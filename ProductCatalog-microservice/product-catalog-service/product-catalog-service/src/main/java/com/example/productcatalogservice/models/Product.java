package com.example.productcatalogservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Integer productId ;
    String productName ;

    public Product(String productName) {
        this.productName = productName ;
    }

}
