package com.reaplm.vendorapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class VendorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorApiApplication.class, args);
	}

}
