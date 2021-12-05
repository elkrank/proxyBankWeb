package com.formation.proxyBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.proxyBank.entities.CompteEpargne;
@Repository
public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, Long> {

}
