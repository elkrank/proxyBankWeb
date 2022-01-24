package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

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
		clientRepository.deleteById(id);
		return "Le client a bien été supprimé";
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

		return clientRepository.save(client);
	}

	

}
