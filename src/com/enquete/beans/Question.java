package com.enquete.beans;

public class Question {
	
	int idQues;
	String titre;
	int idE;
	int idType;
	
	
	public Question() {
		this.idQues=0;
		this.titre="Q1";
		this.idE=0;
		this.idType=0;
		
		
	} 
	
	public Question(int idQues, String titre, int idE, int idType) {
		super();
		this.idQues = idQues;
		this.titre = titre;
		this.idE = idE;
		this.idType = idType;
	}


	public Question(String titre, int idE, int idType) {
		super();
		this.titre = titre;
		this.idE = idE;
		this.idType = idType;
	}


	public int getIdQues() {
		return idQues;
	}


	public void setIdQues(int idQues) {
		this.idQues = idQues;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public int getIdE() {
		return idE;
	}


	public void setIdE(int idE) {
		this.idE = idE;
	}


	public int getIdType() {
		return idType;
	}


	public void setIdType(int idType) {
		this.idType = idType;
	}
	
	

}
