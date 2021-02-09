package com.proj.vo;

public class Patient {

	private Long id;
	private String nom;
	private String prenom;
	private String cin;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String nom, String prenom, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	
	
}
