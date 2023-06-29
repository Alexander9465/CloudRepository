package com.cloudconfig.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudPrueba3ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudPrueba3ConfigApplication.class, args);
	}

}
