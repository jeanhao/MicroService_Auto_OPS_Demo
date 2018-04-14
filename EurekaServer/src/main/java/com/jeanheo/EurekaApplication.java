package com.jeanheo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zenghao
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
}
