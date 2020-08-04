package com.example.demeboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemebootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemebootApplication.class, args);
	}

}
