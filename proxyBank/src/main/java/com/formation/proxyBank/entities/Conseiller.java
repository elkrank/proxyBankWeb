package com.formation.proxyBank.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Conseiller")
public class Conseiller extends Employe {
	@ManyToOne 
	@JsonIgnore
	private Agence agence;
	
	@OneToMany(mappedBy = "conseiller")
	private  List<Client> clients = new ArrayList<Client>();

	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
	}

	public Conseiller() {
	}
	
	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	
	
}
