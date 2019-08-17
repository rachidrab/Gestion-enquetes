package com.enquete.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.enquete.beans.Type;

import com.enquete.connexion.Connex;
import com.enquete.dao.Idao;

public class Typeservice implements Idao<Type> {
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs;
	
	//private int r = 0;

	
	
	public Typeservice() {}
	@Override
	public boolean create(Type o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Type o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Type o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Type findByTitre(String type) {
		con=Connex.getConnex();

		String query = "SELECT * FROM type where titreType='"+type+"';"; 
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				Type t=new Type(rs.getInt("idType"),rs.getString("titreType"));
				return t;
			}else {
				return null;
			}
		}catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Type> findALL() {
		 con=Connex.getConnex();

			String query = "SELECT * FROM type;"; 
			List<Type> l = new ArrayList<>();
			try {
				stmt=con.createStatement();
				ResultSet resultSet = stmt.executeQuery(query);
				while (resultSet.next()) { 
					Type e=new Type(resultSet.getInt("idType"),resultSet.getString("titreType"));
					System.out.println(resultSet.getString("titreType"));
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
