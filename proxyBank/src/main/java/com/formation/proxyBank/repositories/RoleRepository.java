package com.formation.proxyBank.repositories;

import com.formation.proxyBank.Security.RoleEnum;
import com.formation.proxyBank.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
