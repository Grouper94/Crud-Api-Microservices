package com.example.productinfoservice.repository;

import com.example.productinfoservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;


public interface ProductInfoRepository extends JpaRepository<Product,Integer > {

    Product save(Product product) ;

    Optional <Product> findById(Integer productID) ;

    Optional<Product> findByProductName(String productName);

    //@Query("SELECT p FROM Product p  WHERE p.productName = ?1")
    Boolean existsByProductName(String productName) ;

    List<Product> findAll () ;


}
