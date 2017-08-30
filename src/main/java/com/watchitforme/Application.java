package com.watchitforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Starting....");
		SpringApplication.run(Application.class, args);
		System.out.println("APIs ready.");
	}
}
