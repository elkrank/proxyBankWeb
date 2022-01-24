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
			String nom = fullRegisterDto.getNom();
			String prenom = fullRegisterDto.getPrenom();
			String adresse = fullRegisterDto.getAdresse();
			int codePostal = fullRegisterDto.getCodePostal();
			String telephone = fullRegisterDto.getTelephone();

			ClientDto clientDto = new ClientDto();
			clientDto.setNom(nom);
			clientDto.setPrenom(prenom);
			clientDto.setAdresse(adresse);
			clientDto.setCodePostal(codePostal);
			clientDto.setTelephone(telephone);


			Client  client = clientService.createClient(clientDto);

			Long clientID = client.getId();




			CompteCourrant compteCourrant = new CompteCourrant(fullRegisterDto.getNumeroCompteCourrant(),fullRegisterDto.getSoldeCompteCourrant(),client);
			compteCourrantService.creercompteCourrant(compteCourrant.getNumeroDeCompte(),compteCourrant.getSolde(),clientID);
			System.out.println("comptecourant");
			System.out.println(compteCourrant);

			CompteEpargne compteEpargne = new CompteEpargne(fullRegisterDto.getNumeroCompteEpargne(),fullRegisterDto.getSoldeCompteEpargne(),client);
			compteEpargneService.createCompteEpargne(compteEpargne.getNumeroDeCompte(),compteEpargne.getSolde(),clientID);
			System.out.println("compte epargne");
			System.out.println(compteEpargne);

			System.out.println("carte");
			String typeCarte = fullRegisterDto.getTypeDeCarte();
			String numero = fullRegisterDto.getNumeroDeCarte();

			CarteDto carteDto =  new CarteDto();

			carteDto.setIdClient(clientID);
			carteDto.setTypeCarte(typeCarte);
			carteDto.setNumero(numero);
			System.out.println(typeCarte);
			carteService.createCarte(carteDto,clientID);



		}
}
