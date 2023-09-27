package com.viewnext.kidaprojects.biblioteca1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.viewnext.kidaprojects.biblioteca1.model")
@EnableJpaRepositories(basePackages = "com.viewnext.kidaprojects.biblioteca1.repository")
@SpringBootApplication(scanBasePackages = {"com.viewnext.kidaprojects.biblioteca1.service", 
		"com.viewnext.kidaprojects.biblioteca1.restcontroller"})
public class Biblioteca1Application {

	public static void main(String[] args) {
		SpringApplication.run(Biblioteca1Application.class, args);
	}

}
