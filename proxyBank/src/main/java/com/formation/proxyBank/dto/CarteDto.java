package com.formation.proxyBank.dto;

public class CarteDto {
	private String numero;
	private String typeCarte;
	private Long idClient;


	public CarteDto(){

	}

	public CarteDto(String numeroDeCarte,String typeDeCarte,Long Idclient){
		this.idClient = Idclient;
		this.numero = numeroDeCarte;
		this.typeCarte = typeDeCarte;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	
}
