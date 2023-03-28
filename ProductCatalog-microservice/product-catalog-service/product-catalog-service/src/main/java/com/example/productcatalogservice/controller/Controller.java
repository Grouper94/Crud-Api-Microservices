package com.example.productcatalogservice.controller;

import com.example.productcatalogservice.models.CatalogItem;
import com.example.productcatalogservice.models.Rating;
import com.example.productcatalogservice.models.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface Controller {



    @Operation(
            tags = {"Note"},
            summary = "Creates a user by giving user's attributes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "User has been Added Successfully"),
            @ApiResponse(responseCode = "404", description = "User has Not Been  Created")
    })
    ResponseEntity <Optional<User>> addUser(String name, String password) ;

    @Operation(
            tags = {"Note"},
            summary = "Creates a product and a rating for the product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Product has been added sucesfully"),
            @ApiResponse(responseCode = "404", description = "Error adding the Product")
    })
    ResponseEntity <Rating> addItem (Integer userId, String name, Integer rating) ;

    @Operation(
            tags = {"Note"},
            summary = "Return all the rated products for the specific userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Product/s has been returned sucesfully"),
            @ApiResponse(responseCode = "404", description = "userId not found")
    })
    ResponseEntity<Stream<CatalogItem>> getItemsByUserId (Integer userId) ;
}
