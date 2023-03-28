package com.example.productinfoservice.models;


import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {


    public Product (String productName) {
        this.productName = productName ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId ;

    @Column (name = "product_name")
    private String productName ;

}
