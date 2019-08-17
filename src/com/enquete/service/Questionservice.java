package com.enquete.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.enquete.beans.Question;
import com.enquete.connexion.Connex;
import com.enquete.dao.Idao;

public class Questionservice implements Idao<Question> {
	

	private Connection con = null;
	private Statement stmt = null;
	
	private int r = 0;
	

	public Questionservice() {}
	@Override
	public boolean create(Question o) {
		String query = "INSERT into question(titreQues,idType,idEnq) values('"+o.getTitre()+"','"+o.getIdType()+"','"+o.getIdE()+"');"; 
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
	public boolean delete(Question o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Question o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Question findByTitle(int id,String t) { //find a question by id enquete and title
		 con=Connex.getConnex();

			String query ="SELECT * FROM question where idEnq='"+id+"' AND titreQues='"+t+"';";
			try {
				stmt=con.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if(resultSet.next()) { 
					 Question e=new Question(resultSet.getInt("idQues"),resultSet.getString("titreQues"),resultSet.getInt("idEnq"),resultSet.getInt("idType"));
					System.out.println(resultSet.getString("titreQues"));
					return e;
					
				}else {
					return null;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
	}

	
	@Override
	public Question findById(int id) {
		 con=Connex.getConnex();

			String query ="SELECT * FROM question where idQues='"+id+"';";
			try {
				stmt=con.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				if(resultSet.next()) { 
					 Question e=new Question(resultSet.getInt("idQues"),resultSet.getString("titreQues"),resultSet.getInt("idEnq"),resultSet.getInt("idType"));
					System.out.println(resultSet.getString("titreQues"));
					return e;
					
				}else {
					return null;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} 
		
	}

	@Override
	public List<Question> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Question> findALL(int idE) {
	 con=Connex.getConnex();

		String query = "SELECT * FROM question where idEnq='"+idE+"';";
		List<Question> l = new ArrayList<>();
		try {
			stmt=con.createStatement();
			ResultSet resultSet = stmt.executeQuery(query);
			while (resultSet.next()) { 
				 Question e=new Question(resultSet.getInt("idQues"),resultSet.getString("titreQues"),resultSet.getInt("idEnq"),resultSet.getInt("idType"));
				System.out.println(resultSet.getString("titreQues"));
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
