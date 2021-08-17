package com.somveda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:ValidationMessages.properties")
public class SomvedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomvedaApplication.class, args);
	}

}
