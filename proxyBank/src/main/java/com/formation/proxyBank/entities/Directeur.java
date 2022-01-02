package com.formation.proxyBank.entities;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Directeur")
public class Directeur extends Employe {

	@OneToOne(cascade=CascadeType.ALL)
	private Agence agence;

	
	public Directeur() {
		super();
	}

	public Directeur(String nom, String prenom, Agence agence) {
		super(nom, prenom);
		this.agence = agence;
	}
	public Directeur(String username,String email,String password,String nom,String prenom){
		super(username, email, password,nom,prenom);
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	@Override
	public String toString() {
		return "Directeur [agence=" + agence + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + "]";
	}
	
	
}
