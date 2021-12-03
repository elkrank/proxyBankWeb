package com.formation.proxyBank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.proxyBank.entities.CompteCourrant;
import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.repositories.CompteCourrantRepository;

@Service
public class CompteCourrantService {
	@Autowired
	CompteCourrantRepository compteCourrantRepository;

	public CompteCourrant creercompteCourrantService(CompteCourrant compteCourrant) {
		
		return compteCourrantRepository.save(compteCourrant);
	}

}
