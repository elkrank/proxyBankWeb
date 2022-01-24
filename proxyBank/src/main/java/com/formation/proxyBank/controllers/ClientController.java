package com.formation.proxyBank.controllers;

import java.util.List;

import javax.transaction.Transactional;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.dto.FullRegisterDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.repositories.ClientRepository;
import com.formation.proxyBank.service.CarteService;
import com.formation.proxyBank.service.CompteCourrantService;
import com.formation.proxyBank.service.CompteEpargneService;
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
		@Autowired
		ClientRepository clientRepository;
		@Autowired
		CompteCourrantService compteCourrantService;
		@Autowired
		CompteEpargneService compteEpargneService;
		@Autowired
		CarteService carteService;



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
		@CrossOrigin
		@PostMapping("/clients/fullregister/")
		public void fullRegister( @RequestBody FullRegisterDto fullRegisterDto){
			ClientDto clientDto = new ClientDto(fullRegisterDto.getNom(),fullRegisterDto.getPrenom(),
										fullRegisterDto.getAdresse(),fullRegisterDto.getCodePostal()
										,fullRegisterDto.getTelephone());

			Client  client = clientService.createClient(clientDto);

			Long clientID = client.getId();




			CompteCourrant compteCourrant = new CompteCourrant(fullRegisterDto.getNumeroCompteCourrant(),fullRegisterDto.getSoldeCompteCourrant(),client);
			compteCourrantService.creercompteCourrant(compteCourrant.getNumeroDeCompte(),compteCourrant.getSolde(),clientID);

			CompteEpargne compteEpargne = new CompteEpargne(fullRegisterDto.getNumeroCompteEpargne(),fullRegisterDto.getSoldeCompteEpargne(),client);
			compteEpargneService.createCompteEpargne(compteEpargne.getNumeroDeCompte(),compteEpargne.getSolde(),clientID);

			CarteDto carteDto =  new CarteDto(fullRegisterDto.getNumeroDeCarte(),fullRegisterDto.getTypeDeCarte(),clientID);
			carteService.createCarte(carteDto,clientID);

		}
}
