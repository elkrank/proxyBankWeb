package com.formation.proxyBank;

import com.formation.proxyBank.entities.Conseiller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class ProxyBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyBankApplication.class, args);
	}

		@Bean
		public CommandLineRunner run(){
			return(args)-> {
				Conseiller conseiller = new Conseiller("elk","elk@gmail.com","elk");

			};
	}
}
