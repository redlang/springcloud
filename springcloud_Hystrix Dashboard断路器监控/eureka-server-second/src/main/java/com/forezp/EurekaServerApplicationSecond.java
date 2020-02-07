package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplicationSecond {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplicationSecond.class, args);
	}
}
