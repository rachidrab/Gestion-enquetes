package com.enquete.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;
import com.enquete.beans.Enquete;

import com.enquete.connexion.Connex;
import com.enquete.dao.Idao;
import java.sql.Connection;

public class Enqueteservice implements Idao<Enquete>{
	
	private Connection con = null;
	private Statement stmt = null;
	
	private int r = 0;
	
	
	
	

	@Override
	public boolean create(Enquete o) {
		// TODO Auto-generated method stub
		
		String query = "INSERT into enq(titreEnq,descriptionEnq,datedEnq,datefEnq,nombreQstEnq,idUser) values('"+o.getTitre()+"','"+o.getDescription()+"','"+java.sql.Date.valueOf(o.getDateDebut())+"','"+java.sql.Date.valueOf(o.getDateFin())+"','"+o.getNbQuestions()+"','"+o.getIdUser()+"');"; 
		con = (Connection) Connex.getConnex();
		
		try {
			stmt = con.createStatement();
			r = stmt.executeUpdate(query);
			
			System.out.println(r);
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean delete(Enquete o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Enquete o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enquete findById(int id) {
		 con=Connex.getConnex();

			String query = "SELECT * FROM enq where idEnq='"+id+"';";
			try {
				stmt=con.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) { 
					Enquete e=new Enquete(resultSet.getInt("idEnq"),resultSet.getString("titreEnq"),resultSet.getString("descriptionEnq"),resultSet.getDate("datedEnq").toLocalDate(),resultSet.getDate("datefEnq").toLocalDate(),resultSet.getString("etatEnq"),resultSet.getInt("nombreQstEnq"),resultSet.getInt("idUser"));
					System.out.println(resultSet.getString("titreEnq"));
					return e;
				}else {
					
					return null;
				}
				
				
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
			
		}


	@Override
	public List<Enquete> findALL() {
		
		/* con=Connex.getConnex();

		String query = "SELECT * FROM enq;"; 
		List<Enquete> l = new ArrayList<>();
		try {
			stmt=con.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) { 
				 Enquete e=new Enquete(resultSet.getInt("idEnq"),resultSet.getString("titreEnq"),resultSet.getString("descriptionEnq"),resultSet.getDate("datedEnq"),resultSet.getDate("datefEnq"),resultSet.getString("etatEnq"),resultSet.getInt("nombreQstEnq"),resultSet.getInt("idUser"));
				System.out.println(resultSet.getString("titreEnq"));
				l.add(e);
				
			}
			stmt.close();
			 con.close();
			System.out.println(l.toString());
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
			return null;
		//} 
		
		
		
	}
	
	public List<Enquete> findALLU(int id) throws ParseException { // les enquête d'un user 
		
		 con=Connex.getConnex();

		String query = "SELECT * FROM enq where idUser='"+id+"';"; 
		List<Enquete> l = new ArrayList<>();
		try {
			stmt=con.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) { 
				 Enquete e=new Enquete(resultSet.getInt("idEnq"),resultSet.getString("titreEnq"),resultSet.getString("descriptionEnq"),resultSet.getDate("datedEnq").toLocalDate(),resultSet.getDate("datefEnq").toLocalDate(),resultSet.getString("etatEnq"),resultSet.getInt("nombreQstEnq"),resultSet.getInt("idUser"));
				System.out.println(resultSet.getString("titreEnq"));
				l.add(e);
				
			}
			stmt.close();
			 con.close();
			System.out.println(l.toString());
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
		
		
	}
	
	

}
