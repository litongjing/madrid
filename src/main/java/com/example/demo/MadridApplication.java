package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations="classpath*:madrid-config.xml")
@SpringBootApplication
public class MadridApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadridApplication.class, args);
	}
}
