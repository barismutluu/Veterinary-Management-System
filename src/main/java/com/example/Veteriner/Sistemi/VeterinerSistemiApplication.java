package com.example.Veteriner.Sistemi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Veteriner.Sistemi.core.config.swagger", "com.example.Veteriner.Sistemi"})
public class VeterinerSistemiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinerSistemiApplication.class, args);
	}

}
