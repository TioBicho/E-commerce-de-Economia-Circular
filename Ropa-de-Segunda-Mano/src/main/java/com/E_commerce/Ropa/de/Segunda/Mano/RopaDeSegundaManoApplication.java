package com.E_commerce.Ropa.de.Segunda.Mano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RopaDeSegundaManoApplication {

	public static final void main(String[] args) {
		SpringApplication.run(RopaDeSegundaManoApplication.class, args);
	}
}