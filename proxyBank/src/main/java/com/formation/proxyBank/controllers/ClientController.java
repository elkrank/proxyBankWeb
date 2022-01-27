package com.formation.proxyBank.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.dto.FullRegisterDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.entities.CompteEpargne;
import com.formation.proxyBank.repositories.CarteRepository;
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

import io.swagger.annotations.Api;

	@Api(tags = "Client", description = " ")
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
		@Autowired
		CarteRepository carteRepository;



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
		public Long fullRegister( @RequestBody FullRegisterDto fullRegisterDto){
			String nom = fullRegisterDto.getNom();
			String prenom = fullRegisterDto.getPrenom();
			String adresse = fullRegisterDto.getAdresse();
			int codePostal = fullRegisterDto.getCodePostal();
			String telephone = fullRegisterDto.getTelephone();

			String typeCarte = fullRegisterDto.getTypeDeCarte();
			String numero = fullRegisterDto.getNumeroDeCarte();
			
			ClientDto clientDto = new ClientDto();
			clientDto.setNom(nom);
			clientDto.setPrenom(prenom);
			clientDto.setAdresse(adresse);
			clientDto.setCodePostal(codePostal);
			clientDto.setTelephone(telephone);


			Client  client = clientService.createClient(clientDto);

			Long clientID = client.getId();

			CarteDto carteDto =  new CarteDto();



			carteDto.setIdClient(clientID);
			carteDto.setTypeCarte(typeCarte);
			carteDto.setNumero(numero);
			System.out.println(typeCarte);
			Carte carte = carteService.createCarte(carteDto,clientID);
			List<Carte> cartes = new ArrayList<Carte>();
			cartes.add(carte);
			client.setCartes(cartes);
			System.out.println(numero);
			System.out.println(typeCarte);

			clientService.updateClient(clientID,client);


			CompteCourrant compteCourrant = new CompteCourrant(fullRegisterDto.getNumeroCompteCourrant(),fullRegisterDto.getSoldeCompteCourrant(),client);
			compteCourrantService.creercompteCourrant(compteCourrant.getNumeroDeCompte(),compteCourrant.getSolde(),clientID);
			System.out.println("comptecourant");
			System.out.println(compteCourrant);

			CompteEpargne compteEpargne = new CompteEpargne(fullRegisterDto.getNumeroCompteEpargne(),fullRegisterDto.getSoldeCompteEpargne(),client);
			compteEpargneService.createCompteEpargne(compteEpargne.getNumeroDeCompte(),compteEpargne.getSolde(),clientID);
			
			return clientID;
		}

		@CrossOrigin
		@PutMapping("/clients/updateclient")
		public void updateFullClient(@RequestBody FullRegisterDto fullRegisterDto){
			String nom = fullRegisterDto.getNom();
			String prenom = fullRegisterDto.getPrenom();
			String adresse = fullRegisterDto.getAdresse();
			int codePostal = fullRegisterDto.getCodePostal();
			String telephone = fullRegisterDto.getTelephone();

			String typeCarte = fullRegisterDto.getTypeDeCarte();
			String numero = fullRegisterDto.getNumeroDeCarte();

			ClientDto clientDto = new ClientDto();

			clientDto.setNom(nom);
			clientDto.setPrenom(prenom);
			clientDto.setAdresse(adresse);
			clientDto.setCodePostal(codePostal);
			clientDto.setTelephone(telephone);


			Client  client = clientService.getOneClient(fullRegisterDto.getIdClient());
			System.out.println("clientDTO :" + clientDto.getPrenom());
			
			client.setNom(nom);
			client.setPrenom(prenom);
			client.setAdresse(adresse);
			client.setTelephone(telephone);
			client.setCodePostal(codePostal);
			
			Long clientID = client.getId();
			System.out.println("client : " + client.getPrenom());
			CarteDto carteDto =  new CarteDto();

			

			carteDto.setIdClient(clientID);
			carteDto.setTypeCarte(typeCarte);
			carteDto.setNumero(numero);
			System.out.println(typeCarte);
			
			Carte testCarte = carteRepository.getCarteByIdClient(clientID);

			Long idCarte = testCarte.getId();
			
			Carte carte = carteService.modifyCarte(idCarte,carteDto);
			List<Carte> cartes = client.getCartes();
			System.out.println("carte" + carte);
			cartes.remove(0);
			cartes.add(carte);
			client.setCartes(cartes);

			clientService.updateClient(clientID,client);


			CompteCourrant compteCourrant = client.getCompteCourrant();
			compteCourrant.setNumeroDeCompte(fullRegisterDto.getNumeroCompteCourrant());
			compteCourrant.setSolde(fullRegisterDto.getSoldeCompteCourrant());
			compteCourrantService.updateCompteCourrant(compteCourrant.getId(),compteCourrant);


			CompteEpargne compteEpargne = client.getCompteEpargne();
			compteEpargne.setNumeroDeCompte(fullRegisterDto.getNumeroCompteEpargne());
			compteEpargne.setSolde(fullRegisterDto.getSoldeCompteEpargne());
			compteEpargneService.updateCompteEpargne(compteEpargne.getId(),compteEpargne);


		}
}
