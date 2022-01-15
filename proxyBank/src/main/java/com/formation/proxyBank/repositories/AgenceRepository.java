package com.formation.proxyBank.repositories;

import com.formation.proxyBank.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgenceRepository extends JpaRepository<Agence,Long> {
    @Query(value="SELECT compte.solde FROM agence, conseiller, client, compte WHERE agence.id = conseiller.agence_id AND conseiller.id = client.conseiller_id AND client.id = compte.client_id AND agence.id = ?1 AND compte.type_compte='CompteCourrant'",nativeQuery = true)
    List<Double> listeSoldeCompteCourrantAgence(Long agence_id);

    @Query(value="SELECT compte.solde FROM agence, conseiller, client, compte WHERE agence.id = conseiller.agence_id AND conseiller.id = client.conseiller_id AND client.id = compte.client_id AND agence.id = ?1 AND compte.type_compte='CompteEpargne'",nativeQuery = true)
    List<Double> listeSoldeCompteEpargneAgence(Long agence_id);


}
