package com.formation.proxyBank.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("CompteEpargne")
public class CompteEpargne extends Compte {

	private Double tauxRemuneration;

	public CompteEpargne() {
		super();
		this.tauxRemuneration = 0.03;
	}
	public Double getTauxRemuneration() {
		return tauxRemuneration;
	}
	public void setTauxRemuneration(Double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	
	
	

	
	
	
	

}
