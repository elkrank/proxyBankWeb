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
		return directeurRepository.findAll();
	}

	public Optional<Directeur> findDirecteurById(Long id) {
		return directeurRepository.findById(id);
	}

	public void deleteDirecteur(Long id) {
		directeurRepository.deleteById(id);
	}

	public void updateDirecteur(Long id, Directeur directeur) {
		if(directeurRepository.getById(id)!=null){
			Directeur directeurInBdd = directeurRepository.getById(id);
			if(directeur.getNom() == null){
				directeur.setNom(directeurInBdd.getNom());
			}
			if(directeur.getPrenom() == null){
				directeur.setPrenom(directeurInBdd.getPrenom());
			}
			directeurRepository.save(directeur);
		}
		
	}
}
