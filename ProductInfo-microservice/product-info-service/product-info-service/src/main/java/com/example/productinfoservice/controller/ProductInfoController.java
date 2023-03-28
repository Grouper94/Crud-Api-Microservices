package com.example.productinfoservice.controller;

import com.example.productinfoservice.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductInfoController {

    Optional<Product> addProduct (String productName) throws Exception;

    ResponseEntity<Boolean> existProductById  (Integer productId) ;

    Boolean existProductByName  (String productName) ;

    ResponseEntity<List<Product>> getProducts () ;

    ResponseEntity<Optional<Product>> getProductById (Integer productId) ;

    Optional<Product> getProductByName (String productName);

  //  Object getOrCreateProductByName (String productName);

    Boolean deleteProductById (Integer productId);



}
