package com.security.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class SpringSecurityServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityServerApplication.class, args);
	}

	@RequestMapping(value = "/products")
	public String getProductName() {
		return "Honey";
	}
}
