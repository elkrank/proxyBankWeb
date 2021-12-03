package com.formation.proxyBank.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CompteCourrant")
public class CompteCourrant extends Compte {
	private Double autorisationDecouverte;

	public CompteCourrant(int numeroDeCompte, double solde, Client client) {
		super(numeroDeCompte, solde, client);
		this.autorisationDecouverte = 1000.00;
	}

	public CompteCourrant() {
		super();
	}

	public Double getAutorisationDecouverte() {
		return autorisationDecouverte;
	}

	public void setAutorisationDecouverte(Double autorisationDecouverte) {
		this.autorisationDecouverte = autorisationDecouverte;
	}

	@Override
	public String toString() {
		return "CompteCourrant [autorisationDecouverte=" + autorisationDecouverte + "]";
	} 
	
	
	

}
