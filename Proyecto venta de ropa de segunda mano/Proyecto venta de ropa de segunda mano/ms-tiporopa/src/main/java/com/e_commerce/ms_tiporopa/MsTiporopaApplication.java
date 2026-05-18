package com.e_commerce.ms_tiporopa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients; // <--- 1. Revisa que esté este import

@EnableFeignClients
@SpringBootApplication
public class MsTiporopaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsTiporopaApplication.class, args);
	}
}