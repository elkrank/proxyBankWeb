package com.formation.proxyBank.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.service.ClientService;


	@RestController
	@RequestMapping("/proxybank")
	public class ClientController {
		
		@Autowired
		ClientService clientService;
		
		@PostMapping(value = "/clients", consumes = "application/json")
		public Client createClient(@RequestBody ClientDto clientDto) {
			return clientService.createClient(clientDto);
		}	
		
		@GetMapping("/clients")
		public List<Client> getAllClients() {
			return clientService.getAllClients();
		}
		
		@GetMapping("/clients/{id}")
		public Client getClient(@PathVariable Long id) {
			return clientService.getOneClient(id);
		}
		
		@Transactional
		@DeleteMapping("/clients/{id}")
		public void deleteClient(@PathVariable Long id) {
			clientService.deleteClient(id);
		}
		
		@PutMapping("/clients/{id}")
		public Client updateClient (@PathVariable Long id, @RequestBody Client ClientUpdate) {
			Client client = clientService.updateClient(id, ClientUpdate);
			return client;
		}
}
