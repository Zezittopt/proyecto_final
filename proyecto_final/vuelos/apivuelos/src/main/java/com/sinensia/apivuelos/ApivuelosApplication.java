package com.sinensia.apivuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.sinensia.repository")
@EntityScan(basePackages = "com.sinensia.model")
@SpringBootApplication(scanBasePackages = {"com.sinensia.controller", "com.sinensia.service"})
public class ApivuelosApplication {

	
	/** 
	 * MICROSERVICIO DE VUELOS
	 * 
	 * AUTOR: CLAUDIO BARBOSA
	 * VERSION: 1.00
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ApivuelosApplication.class, args);
	}

}
