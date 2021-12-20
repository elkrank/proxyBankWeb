package com.formation.proxyBank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.entities.Client;
import com.formation.proxyBank.repositories.CarteRepository;
import com.formation.proxyBank.repositories.ClientRepository;




@Service
public class CarteService {
	
	@Autowired CarteRepository carteRepository;
	@Autowired ClientRepository clientRepository;
	

	public Carte createCarte(CarteDto dto, Long clientId) {
		Carte carte = new Carte();
		//Optional<Client> client = clientRepository.findById(clientId);
		carte.setIdClient(dto.getIdClient());
		carte.setNumero(dto.getNumero());
		carte.setTypeCarte(dto.getTypeCarte());
		
		return carteRepository.save(carte);
	}

	public Carte getCarteById(Long id) {
		return carteRepository.getById(id);
	}
	
	public void deleteCarte(Long id) {
		carteRepository.deleteById(id);
	}
	
	public Carte modifyCarte(Long id, CarteDto dto) {
		Carte carte = carteRepository.getById(id);
		carte.setNumero(dto.getNumero());
		carte.setTypeCarte(dto.getTypeCarte());
		return carteRepository.save(carte);
	}
}
