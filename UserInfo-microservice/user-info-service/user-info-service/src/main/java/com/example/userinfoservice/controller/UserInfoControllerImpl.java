package com.example.userinfoservice.controller;

import com.example.userinfoservice.models.User;
import com.example.userinfoservice.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/UserMethods")
public class UserInfoControllerImpl  implements  UserInfoController {
   UserInfoService userInfoService;

   @Autowired
   public UserInfoControllerImpl(UserInfoService userInfoService) {
      this.userInfoService = userInfoService;
   }


   @Override
   @PostMapping("/create")
   public User addUser(@RequestBody User user) {
      User usr = new User()  ;
      System.out.println( user.toString()+"++++++++++++++" ) ;

      try {
         usr = userInfoService.addUser(user);
      }
      catch (Exception e){
         System.out.println("EEEEEEEEEEEEEEErrror");
      }
      System.out.println( usr.toString()+"-------------------" ) ;
      usr.toString() ;
      return usr ;
   }

   @Override
   @GetMapping("/user-exist/{userId}")
   public Boolean existUser (@PathVariable Integer userId) {
      return  userInfoService.existUserById(userId) ;
   }

   @Override
   @GetMapping("/users-get-all")
   public List<User> getUsers ()  {
      return   userInfoService.getUsers() ;
   }

   @Override
   @DeleteMapping("/users-delete-all")
   public Boolean deleteUsers()  {
      return userInfoService.deleteUsers() ;
   }

   @Override
   @DeleteMapping("/user-deleteById/{userId}")
   public Boolean deleteUserById(@PathVariable Integer userId)  {

      return userInfoService.deleteUserById(userId) ;
   }
}






