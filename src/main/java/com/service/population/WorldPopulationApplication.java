package com.service.population;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WorldPopulationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldPopulationApplication.class, args);
	}
}
