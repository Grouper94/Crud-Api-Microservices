package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.models.CatalogItem;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.models.Rating;
import com.example.productcatalogservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RestController
@RequestMapping("/userApi")
public class ControllerImpl  implements Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder ;


    @Override
    @GetMapping("/create-user/{name}/{password}")
    public ResponseEntity<Optional<User>> addUser(@PathVariable String name, @PathVariable String password) {

        Optional<User> user = Optional.ofNullable(webClientBuilder.build()
                .post()
                .uri("http://user-info/UserMethods/create")
                .body(Mono.just(new User(name, password)), User.class)
                .retrieve()
                .bodyToMono(User.class)
                .block());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    @Override
    @GetMapping("/create-product-rating/{userId}/{productName}/{productRating}")
    public ResponseEntity <Rating> addItem (@PathVariable Integer userId,@PathVariable  String productName, @PathVariable Integer productRating) {

      Optional<Product> product = Optional.ofNullable(webClientBuilder.build()
              .post()
              .uri("http://product-info/ProductsMethods/create/{productName}", productName)
              .retrieve()
              .bodyToMono(Product.class)
              .block());

      Rating rating = webClientBuilder.build()
                .post()
                .uri("http://rating-info/Ratings/create-rating")
                .body( Mono.just(new Rating(userId, product.get().getProductId(), productRating)), Rating.class)
                .retrieve()
                .bodyToMono(Rating.class)
                .block();

        return new ResponseEntity<>(rating, HttpStatus.OK);
    }


    @Override
    @GetMapping("/get-ratedProducts-ByUserId/{userId}")
    public ResponseEntity<Stream<CatalogItem>> getItemsByUserId (@PathVariable  Integer userId) {

         List<Rating> ratings = webClientBuilder.build()
                 .get()
                 .uri("http://rating-info/Ratings/get-ratings-userId/{userId}", userId)
                 .retrieve()
                 .bodyToMono(new ParameterizedTypeReference<List<Rating>>() {})
                 .block();

       Stream<CatalogItem> items  =  ratings.stream().map(rating -> {
                    Product product = webClientBuilder.build()
                    .get()
                    .uri("http://product-info/ProductsMethods/product-get-ById/{productId}", rating.getProductId())
                    .retrieve()
                    .bodyToMono(Product.class)
                    .block();
              return new CatalogItem(product.getProductName(), rating.getProductRating()) ;
       })  ;

       return new ResponseEntity<>(items,HttpStatus.OK);

    }



}










