package com.example.latihan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class LatihanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatihanApplication.class, args);
	}

	@GetMapping("hello")
	public String hello() {
		return "Hello From Spring Boot";
	}

}
