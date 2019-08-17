package com.enquete.beans;

public class Option {
	private int ido;
	private String titre;
	private int idq;
	
	public Option(int ido, int idq, String titre) {
		super();
		this.ido = ido;
		this.titre = titre;
		this.idq = idq;
	}
	
	public Option(String titre, int idq) {
		super();

		this.titre = titre;
		this.idq = idq;
	}
	public int getIdo() {
		return ido;
	}
	public void setIdo(int ido) {
		this.ido = ido;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getIdq() {
		return idq;
	}
	public void setIdq(int idq) {
		this.idq = idq;
	}

}
