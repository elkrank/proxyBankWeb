package com.formation.proxyBank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProxyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyBankApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {

		};
	}
}
