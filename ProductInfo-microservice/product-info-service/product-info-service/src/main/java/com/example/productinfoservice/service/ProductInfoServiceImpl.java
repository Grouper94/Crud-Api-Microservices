package com.example.productinfoservice.service;

import com.example.productinfoservice.models.Product;
import com.example.productinfoservice.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements  ProductInfoService {

    ProductInfoRepository productInfoRepository ;

    @Autowired
    public ProductInfoServiceImpl(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository ;
    }

   public Optional<Product> addProduct(String productName) {
      return Optional.of(productInfoRepository.findByProductName(productName)
              .orElseGet(() -> (productInfoRepository.save(new Product(productName)))));
   }

   public  Boolean existProductById  (Integer productId) {

        return productInfoRepository.existsById(productId);
   }

  public Boolean existProductByName  (String productName) {

        return  productInfoRepository.existsByProductName(productName);
  }

   public List<Product> getProducts () {
        return productInfoRepository.findAll() ;
   }

    public Optional<Product> getProductById (Integer productId) {
        return productInfoRepository.findById(productId) ;
    }

   public  Optional<Product> getProductByName(String productName) {
       return productInfoRepository.findByProductName(productName) ;
   }

   public Boolean deleteProductById (Integer productId) {
      productInfoRepository.deleteById(productId) ;
      return !productInfoRepository.existsById(productId) ;
   }

//   public Optional<Product>  getOrCreateProductByName(String productName) {
//       return Optional.of(productInfoRepository.findByProductName(productName)
//               .orElseGet(() -> (productInfoRepository.save(productName))));
//
//   }




}
