package com.example.userinfoservice.service;

import com.example.userinfoservice.models.User;
import com.example.userinfoservice.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    RestTemplate restTemplate ;

    UserInfoRepository userInfoRepository ;


    UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public User addUser (User user) {
        return  userInfoRepository.save(user) ;
    }

    @Override
    public Boolean existUserById(Integer userId) {
        return userInfoRepository.existsById(userId) ;
    }

    @Override
    public List<User>  getUsers () {
        return userInfoRepository.findAll() ;
    }

    @Override
    public Boolean deleteUsers() {
        userInfoRepository.deleteAll();
        return userInfoRepository.findAll().isEmpty();
    }

    @Override
    public Boolean deleteUserById(Integer userId) {
        HttpEntity<Boolean> entity = new HttpEntity<>(null);
        ResponseEntity<Boolean> userExist = restTemplate.exchange("http://localhost:8084/Ratings/delete-ratingByUserId/:userId", HttpMethod.GET, entity, Boolean.class, userId);

        if (Boolean.TRUE.equals(userExist.getBody()))
            userInfoRepository.deleteById(userId);

        return !userInfoRepository.existsById(userId);
    }
}
