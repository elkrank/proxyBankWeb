package com.formation.proxyBank.repositories;


import com.formation.proxyBank.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompteRepository extends JpaRepository<Compte,Long> {
    @Query(value="SELECT type_compte FROM compte WHERE id=?1 ",nativeQuery = true)
    String getTypeCompte(Long id);

}
