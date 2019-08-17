package com.enquete.beans;

public class User {
	
	private int idU;
	private String nom ;
	private String prenom;
	private String email;
	private String telephone;
	private String entreprise;
	private String login;
	private String motdepasse;
	
	
	public User() {
		this.nom ="Ait";
		this.prenom ="Raja";
		this.email ="raja@gmail.com";
		this.telephone ="0636363636";
		this.entreprise ="EMSI";
		this.login ="RAJAAIT";
		this.motdepasse ="1234";
		
		
	} 
	public User(int idU,String nom, String prenom, String email, String telephone, String entreprise, String login,
			String motdepasse) {
		super();
		this.idU=idU;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.entreprise = entreprise;
		this.login = login;
		this.motdepasse = motdepasse;
	}
	
	public User(String nom, String prenom, String email, String telephone, String entreprise, String login,
			String motdepasse) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.entreprise = entreprise;
		this.login = login;
		this.motdepasse = motdepasse;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	
}
