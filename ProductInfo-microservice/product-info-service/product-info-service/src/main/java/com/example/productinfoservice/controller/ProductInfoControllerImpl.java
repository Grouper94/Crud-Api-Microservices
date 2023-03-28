package com.example.productinfoservice.controller;

import com.example.productinfoservice.models.Product;
import com.example.productinfoservice.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ProductsMethods")
public class ProductInfoControllerImpl implements  ProductInfoController {
    private final   ProductInfoService productInfoService;

    @Autowired
    public ProductInfoControllerImpl(ProductInfoService productInfoService) {
        this.productInfoService = productInfoService;
    }


    @Override
    @PostMapping("/create/{productName}")
    public Optional<Product> addProduct(@PathVariable String productName) throws Exception {
      return  productInfoService.addProduct(productName);
    }

    @Override
    @GetMapping("/product-existId/{productId}")
    public ResponseEntity<Boolean> existProductById(@PathVariable Integer productId) {
        return new ResponseEntity<>(productInfoService.existProductById(productId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/product-existName/{productName}")
    public Boolean existProductByName(@PathVariable String productName) {
        return productInfoService.existProductByName(productName);
    }

    @Override
    @GetMapping("/products-get-all")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(productInfoService.getProducts(), HttpStatus.OK);

    }

    @Override
    @GetMapping("/product-get-ById/{productId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer productId) {
        return new ResponseEntity<>(productInfoService.getProductById(productId), HttpStatus.OK);
    }

    @Override
    @GetMapping("/product-get-ByName/{productName}")
    public Optional<Product> getProductByName(@PathVariable String productName) {
        return productInfoService.getProductByName(productName);
    }

//    @Override
//    @GetMapping("/product-getIfNotCreate-ByName/{productName}")
//    public Optional<Product> getOrCreateProductByName(@PathVariable String productName) {
//
//
//      if(productInfoService.getProductByName(productName).isEmpty())
//          return productInfoService.addProduct(new Product(productName));
//      return  productInfoService.getProductByName(productName);
//
//    }


    @Override
    @DeleteMapping("/product-delete-ById/{productId}")
    public Boolean deleteProductById(@PathVariable  Integer productId) {
        return productInfoService.deleteProductById(productId);
    }
}













