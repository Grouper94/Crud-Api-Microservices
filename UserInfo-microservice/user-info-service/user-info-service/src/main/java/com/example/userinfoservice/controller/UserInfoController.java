package com.example.userinfoservice.controller;

import com.example.userinfoservice.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UserInfoController {

    User addUser(User user) ;

    Boolean existUser (Integer userId) ;

    List<User> getUsers () ;

    Boolean deleteUsers() ;

    Boolean deleteUserById(Integer userId) ;



}
