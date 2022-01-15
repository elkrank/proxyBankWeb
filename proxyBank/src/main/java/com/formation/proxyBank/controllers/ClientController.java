package com.formation.proxyBank.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.service.ClientService;


	@RestController
	public class ClientController {
		
		@Autowired
		ClientService clientService;
		@CrossOrigin
		@PostMapping(value = "/clients", consumes = "application/json")
		public Client createClient(@RequestBody ClientDto clientDto) {
			return clientService.createClient(clientDto);
		}

		@CrossOrigin
		@GetMapping("/clients")
		public List<Client> getAllClients() {
			return clientService.getAllClients();
		}

		@CrossOrigin
		@GetMapping("/clients/{id}")
		public Client getClient(@PathVariable Long id) {
			return clientService.getOneClient(id);
		}
		@CrossOrigin
		@Transactional
		@DeleteMapping("/clients/{id}")
		public void deleteClient(@PathVariable Long id) {
			clientService.deleteClient(id);
		}

		@CrossOrigin
		@PutMapping("/clients/{id}")
		public Client updateClient (@PathVariable Long id, @RequestBody Client ClientUpdate) {
			Client client = clientService.updateClient(id, ClientUpdate);
			return client;
		}
}
