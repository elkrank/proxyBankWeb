package com.formation.proxyBank.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.formation.proxyBank.entities.Conseiller;
import com.formation.proxyBank.service.ConseillerService;
@Repository
public interface ConseillerRepository extends JpaRepository<Conseiller, Long> {
	
}
