package com.formation.proxyBank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Conseiller")
public class Conseiller extends Employe {
//	@OneToMany(mappedBy = "client")
//	private  List<Client> clients = new ArrayList<Client>();

	public Conseiller(String nom, String prenom) {
		super(nom, prenom);
	}
//
//	public List<Client> getClients() {
//		return clients;
//	}
//
//	public void setClients(List<Client> clients) {
//		this.clients = clients;
//	}
	
	
	
}
