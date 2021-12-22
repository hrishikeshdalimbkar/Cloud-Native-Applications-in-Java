package com.cybage.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")
public class ProductAppliction {

	public static void main(String[] args) {
		SpringApplication.run(ProductAppliction.class, args);
	}

}
