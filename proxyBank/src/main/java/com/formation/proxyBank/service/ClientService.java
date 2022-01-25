package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.entities.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	CompteService compteService;
	@Autowired
	CompteCourrantService compteCourrantService;
	@Autowired
	CompteEpargneService compteEpargneService;

	public Client createClient(ClientDto dto) {
		Client client = new Client();
		client.setPrenom(dto.getPrenom());
		client.setNom(dto.getNom());
		client.setAdresse(dto.getAdresse());
		client.setCodePostal(dto.getCodePostal());
		client.setTelephone(dto.getTelephone());
		System.out.println("client service");
		System.out.println(client);
		return clientRepository.save(client);
	}

	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	public Client getOneClient(Long id) {
	Client client = clientRepository.getById(id);
		return client;
	}
	
	public String deleteClient(Long id)  {

		Client client = clientRepository.getById(id);

		CompteCourrant compteCourrant =client.getCompteCourrant();

		CompteEpargne compteEpargne = client.getCompteEpargne();

		if(compteCourrant.getSolde()<=0 && compteEpargne.getSolde() ==0){
			compteCourrantService.deleteCompteCourrant(compteCourrant.getId());
			compteEpargneService.deleteCompteEpargne(compteEpargne.getId());
			clientRepository.deleteById(id);
			return "Le client a bien été supprimé";
		}else{
			return "Le client n'a pas ses comptes à zéro la suppression est impossible, vérifier les soldes des comptes";
		}
	}

	public Client updateClient(Long id, Client ClientUpdate) {
		Client client = clientRepository.getById(id);
		client.setAdresse(ClientUpdate.getAdresse());
		client.setNom(ClientUpdate.getNom());
		client.setPrenom(ClientUpdate.getPrenom());
		client.setCodePostal(ClientUpdate.getCodePostal());
		client.setTelephone(ClientUpdate.getTelephone());
		client.setCompteCourrant(ClientUpdate.getCompteCourrant());
		client.setCompteEpargne(ClientUpdate.getCompteEpargne());
		client.setCartes(ClientUpdate.getCartes());

		return clientRepository.save(client);
	}

	

}
