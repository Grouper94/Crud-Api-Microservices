package com.example.productcatalogservice.models;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Integer userId ;
    String userName;
    String userPassword  ;


    public User (String userName,String userPassword) {
        this.userName = userName ;
        this.userPassword = userPassword ;
    }


}
