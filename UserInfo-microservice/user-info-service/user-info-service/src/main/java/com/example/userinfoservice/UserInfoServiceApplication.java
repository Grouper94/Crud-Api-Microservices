package com.example.userinfoservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class UserInfoServiceApplication implements CommandLineRunner {

	@Bean
	public RestTemplate getRestTemplate () {
		return new RestTemplate() ;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserInfoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
