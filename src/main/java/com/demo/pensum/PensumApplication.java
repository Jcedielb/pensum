package com.demo.pensum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.pensum")
public class PensumApplication {
	public static void main(String[] args) {
		SpringApplication.run(PensumApplication.class, args);
	}

}
