package com.example.userinfoservice.models;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    public User (String userName,String userPassword) {
        this.userName = userName ;
        this.userPassword = userPassword;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId ;

    @Column(name = "user_name")
    private String userName ;

    @Column(name = "user_password")
    private String userPassword  ;

}
