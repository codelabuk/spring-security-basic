package com.labuk.spring_boot_security_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootSecurityBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityBasicApplication.class, args);
	}

}
