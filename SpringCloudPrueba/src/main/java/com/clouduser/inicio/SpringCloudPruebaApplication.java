package com.clouduser.inicio;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.clouduser.entity")
@EnableJpaRepositories(basePackages = "com.clouduser.repository")
@SpringBootApplication(scanBasePackages = {"com.clouduser.controller","com.clouduser.service"})

public class SpringCloudPruebaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPruebaApplication.class, args);
			
		
		
	}
	 
	

}
