package com.example.userinfoservice.repository;

import com.example.userinfoservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository  extends JpaRepository <User, Integer > {

    User save(User user) ;

    List<User> findAll() ;

    void deleteAll();







}
