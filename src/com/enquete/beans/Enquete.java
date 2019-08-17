package com.enquete.beans;

import java.text.ParseException;

import java.time.LocalDate;

public class Enquete {
	
		int idE;
		String titre;
		String description;
		LocalDate  dateDebut;
		LocalDate dateFin;
		int nbQuestions;
		String etat;
		int idUser;
		LocalDate d=LocalDate.now();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		public Enquete() {
			this.idE=0;
			this.titre ="Enq";
			this.description ="Pas description";
			this.dateDebut =LocalDate.now();
			this.dateFin =LocalDate.now();
			this.nbQuestions =5;
			this.etat ="Pas encore commencé";
			this.idUser=1;
			
		}
		
		public Enquete(String titre, String description,LocalDate dateDebut,LocalDate  dateFin,String etat, int nbQuestions,int idUser) throws ParseException {
			super();
			this.titre = titre;
			this.description = description;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.nbQuestions = nbQuestions;
			this.idUser=idUser;
			
			if (dateDebut.compareTo(LocalDate.now())>0) {
				this.etat="Pas encore commencé";
					
			} else if(dateDebut.compareTo(LocalDate.now())<=0 && dateFin.compareTo(LocalDate.now())<0) {
				
				this.etat="En cours";
				
				
			}else {
				
				this.etat="Fini";
				
			}
		
		}	
		
		public Enquete(int idE,String titre, String description, LocalDate   dateDebut,LocalDate dateFin,String etat, int nbQuestions,int idUser) throws ParseException {
			super();
			this.idE=idE;
			this.titre = titre;
			this.description = description;
			this.dateDebut = dateDebut;
			this.dateFin = dateFin;
			this.nbQuestions = nbQuestions;
			this.idUser=idUser;
			if (dateDebut.compareTo(LocalDate.now())>0) {
				this.etat="Pas encore commencé";
					
			} else if(dateDebut.compareTo(LocalDate.now())<=0 && dateFin.compareTo(LocalDate.now())>0) {
				
				this.etat="En cours";
				
				
			}else {
				
				this.etat="Fini";
				
			}
			
		}	


		public int getIdE() {
			return idE;
		}

		public void setIdE(int idE) {
			this.idE = idE;
		}

		public String getEtat() {
			return etat;
		}

		public void setEtat(String etat) {
			this.etat = etat;
		}

		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate  getDateDebut() {
			return dateDebut;
		}
		public void setDateDebut(LocalDate   dateDebut) {
			this.dateDebut = dateDebut;
		}
		public LocalDate   getDateFin() {
			return dateFin;
		}
		public void setDateFin(LocalDate   dateFin) {
			this.dateFin = dateFin;
		}
		public int getNbQuestions() {
			return nbQuestions;
		}
		public void setNbQuestions(int nbQuestions) {
			this.nbQuestions = nbQuestions;
		}


		public int getIdUser() {
			return idUser;
		}


		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		
		
		
		
		
		
		

	


}
