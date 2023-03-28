package com.example.productinfoservice.service;

import com.example.productinfoservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {

    Optional<Product> addProduct(String productName);

    Boolean existProductById  (Integer productId) ;

    Boolean existProductByName  (String productName) ;

    List<Product> getProducts () ;

    Optional<Product> getProductById(Integer productId) ;

    Optional<Product> getProductByName(String productName);

    Boolean deleteProductById (Integer productId) ;

  //  Optional<Product>  getOrCreateProductByName(String productName) ;

}
