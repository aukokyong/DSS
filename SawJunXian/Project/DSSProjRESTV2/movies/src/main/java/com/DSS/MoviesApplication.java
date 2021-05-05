package com.DSS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		System.out.println("Starting Spring Boot!");
		SpringApplication.run(MoviesApplication.class, args);
	}

}
