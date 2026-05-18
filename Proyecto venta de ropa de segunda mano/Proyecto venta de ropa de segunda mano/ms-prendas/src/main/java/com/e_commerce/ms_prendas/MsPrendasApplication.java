package com.e_commerce.ms_prendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsPrendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsPrendasApplication.class, args);
	}
}