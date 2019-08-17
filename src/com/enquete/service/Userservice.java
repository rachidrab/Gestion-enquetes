package com.enquete.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.enquete.dao.Idao;
import com.mysql.jdbc.Connection;
import com.enquete.connexion.*;

import com.enquete.beans.*;

public class Userservice implements Idao<User> {
	private Connection con = null;
	private Statement stmt = null;
	private int r = 0;
	private ResultSet rs;

	
	public Userservice() {
		
		
	}

	@Override
	public boolean create(User o) {
		String query = "INSERT into user(nomUser,prenomUser,loginUser,telephoneUser,emailUser,entrepriseUser,motdepasseUser) values('"+o.getNom()+"','"+o.getPrenom()+"','"+o.getLogin()+"','"+o.getTelephone()+"','"+o.getEmail()+"','"+o.getEntreprise()+"','"+o.getMotdepasse()+"');"; 
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			r = stmt.executeUpdate(query);
			
			System.out.println(r);
			
			con.close();
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	return false;
	}


	public boolean findByemail(String em) { //verification de l'utilisation de l'email
		String query = "select * from user where  emailUser ='"+em+"';";
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}else
			{
				return false;
			}

		}catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean findBylogin(String em) { //verification de l'utilisation de login
		String query = "select * from user where  loginUser ='"+em+"';";
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}else
			{
				return false;
			}

		}catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}
	
	public boolean findBylogin(String nomutilisateurU,String mpU) { //verification de validation de login et mdp
		String query = "select * from user where  loginUser ='"+nomutilisateurU +"' and motdepasseUser='"+ mpU +"';";
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				return true;
			}else
			{
				return false;
			}

		}catch (SQLException e) {

			e.printStackTrace();
			return false;
		}
	}

	

	
	public User findUser(String login) {//recuperation des infos d'un user à l'aide de login (variable de session)
		String query = "select * from user where  loginUser ='"+login+"';";
		try {
			con = (Connection) Connex.getConnex();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				User u=new User(rs.getInt("idUser"),rs.getString("nomUser"), rs.getString("prenomUser"),rs.getString("emailUser"),rs.getString("telephoneUser"),rs.getString("entrepriseUser"),rs.getString("loginUser"),
						rs.getString("motdepasseUser"));
				return u;
			}else {
				return null;
			}
		}catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public boolean delete(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User o) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findALL() {
		// TODO Auto-generated method stub
		return null;
	}
}
