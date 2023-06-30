package com.cloudregister.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudPrueba4RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPrueba4RegisterApplication.class, args);
	}

}
