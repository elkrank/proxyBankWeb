package com.formation.proxyBank.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type_compte")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDeCompte;
	private Double solde;
	private LocalDate dateOuverture;

	@ManyToOne
	@JsonIgnore
	private Client client;

	public Compte() {
		super();
	}

	public Compte(Integer numeroDeCompte, Double solde, Client client) {
		super();
		this.numeroDeCompte = numeroDeCompte;
		this.solde = solde;
		this.dateOuverture = LocalDate.now();
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDeCompte() {
		return numeroDeCompte;
	}

	public void setNumeroDeCompte(Integer numeroDeCompte) {
		this.numeroDeCompte = numeroDeCompte;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public LocalDate getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(LocalDate dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [id=" + id + ", numeroDeCompte=" + numeroDeCompte + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + ", client=" + client + "]";
	}

}
