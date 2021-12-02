package com.formation.proxyBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.service.ClientService;


	@RestController
	public class ClientController {
		
		@Autowired
		ClientService clientService;
		
		@PostMapping(value = "/clients", consumes = "application/json")
		public Client createClient(@RequestBody ClientDto clientDto) {
			return clientService.createClient(clientDto);
		}	
}
