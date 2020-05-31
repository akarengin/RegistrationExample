package com.enginakar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.enginakar.repos")
@SpringBootApplication
public class RegistrationExample extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RegistrationExample.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RegistrationExample.class, args);
	}

}
