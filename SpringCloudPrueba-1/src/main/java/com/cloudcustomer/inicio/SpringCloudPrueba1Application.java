package com.cloudcustomer.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.cloudcustomer.entity")
@EnableJpaRepositories(basePackages = "com.cloudcustomer.repository")
@SpringBootApplication(scanBasePackages = {"com.cloudcustomer.controller","com.cloudcustomer.service"})
public class SpringCloudPrueba1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPrueba1Application.class, args);
	}

}
