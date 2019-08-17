package com.enquete.beans;

public class Type {
	int idType;
	String titre;
	
	public Type() {
		
		this.idType =0;
		this.titre = "T1";
	}
	
	
	public Type(int idType, String titre) {
		super();
		this.idType = idType;
		this.titre = titre;
	}
	public int getIdType() {
		return idType;
	}
	public void setIdType(int idType) {
		this.idType = idType;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	

}
