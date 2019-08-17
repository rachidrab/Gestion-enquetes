package com.enquete.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.enquete.beans.Option;
import com.enquete.beans.Question;
import com.enquete.connexion.Connex;
import com.enquete.dao.Idao;

public class Optionservice implements Idao<Option> {
	

	private Connection con = null;
	private Statement stmt = null;
	
	private int r = 0;
	
	public Optionservice() {};
	
	@Override
	public boolean create(Option o) {
		String query = "INSERT into opt(idQues,titreOp) values('"+o.getIdq()+"','"+o.getTitre()+"');"; 
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
	public boolean delete(Option o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Option o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Option findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Option> findALL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Option> findALL(int idQ) {
		 con=Connex.getConnex();

			String query = "SELECT * FROM opt where idQues='"+idQ+"';";
			List<Option> l = new ArrayList<>();
			try {
				stmt=con.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				while (resultSet.next()) { 
					 Option e=new Option(resultSet.getInt("idOp"),resultSet.getInt("idQues"),resultSet.getString("titreOp"));
					System.out.println(resultSet.getString("idOp"));
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
