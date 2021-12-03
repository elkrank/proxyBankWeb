package com.formation.proxyBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.dto.CarteDto;
import com.formation.proxyBank.entities.Carte;
import com.formation.proxyBank.repositories.CarteRepository;


@Service
public class CarteService {
	
	@Autowired CarteRepository carteRepository;

	public Carte createCarte(CarteDto dto) {
		Carte carte = new Carte();
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
}
