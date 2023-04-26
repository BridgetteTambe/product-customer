package com.bree.com;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProductCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCustomerApplication.class, args);
	}

}
