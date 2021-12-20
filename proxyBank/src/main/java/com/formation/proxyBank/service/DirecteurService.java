package com.formation.proxyBank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.Directeur;
import com.formation.proxyBank.repositories.DirecteurRepository;

@Service
public class DirecteurService {

	@Autowired
	DirecteurRepository directeurRepository;

	public Directeur createDirecteur(Directeur directeur) {
		return directeurRepository.save(directeur);
	}

	public List<Directeur> listerDirecteur() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Directeur> findDirecteurById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteDirecteur(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void updateDirecteur(Long id, Directeur directeur) {
		// TODO Auto-generated method stub
		
	}
}
