package com.example.userinfoservice.service;

import com.example.userinfoservice.models.User;

import java.util.List;


public interface UserInfoService {
    User addUser(User user ) ;

    Boolean existUserById(Integer userId);

    List<User> getUsers();

    Boolean deleteUsers();

    Boolean deleteUserById(Integer userId);
}
