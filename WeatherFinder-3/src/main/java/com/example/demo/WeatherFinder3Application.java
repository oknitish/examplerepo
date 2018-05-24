package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication(scanBasePackages={"com.example.demo"})
public class WeatherFinder3Application {

	public static void main(String[] args) {
		SpringApplication.run(WeatherFinder3Application.class, args);
	}
}
