package com.ajinkya.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ajinkya.controller")
public class SpringBootWhiteLabelErrorMessageAppDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWhiteLabelErrorMessageAppDemoApplication.class, args);
	}

}
