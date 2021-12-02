package com.formation.proxyBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.dto.ClientDto;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired ClientRepository clientRepository;


	public Client createClient(ClientDto dto) {
		Client client = new Client();
		client.setPrenom(dto.getPrenom());
		client.setNom(dto.getNom());
		client.setAdresse(dto.getAdresse());
		client.setCodePostal(dto.getCodePostal());
		client.setTelephone(dto.getTelephone());
		return clientRepository.save(client);
	}

}
