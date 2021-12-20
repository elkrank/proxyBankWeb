package com.formation.proxyBank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.formation.proxyBank.service.ClientService;

@Entity
public class Carte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean active = true;
	private String typeCarte;
	private String numero;
	
	private Long idClient;

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	
	public Long getIdClient() {
		return idClient;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Carte [active=" + active + ", typeCarte=" + typeCarte + ", numero=" + numero + "]";
	}

}
