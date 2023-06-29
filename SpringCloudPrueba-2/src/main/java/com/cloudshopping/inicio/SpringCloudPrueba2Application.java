package com.cloudshopping.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.cloudshopping.entity")
@EnableJpaRepositories(basePackages = "com.cloudshopping.repository")
@SpringBootApplication(scanBasePackages = {"com.cloudshopping.controller","com.cloudshopping.service"})
public class SpringCloudPrueba2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPrueba2Application.class, args);
	}

}
