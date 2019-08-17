package com.enquete.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enquete.beans.*;

import com.enquete.service.*;
/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		String entreprise=request.getParameter("entreprise");
		String login=request.getParameter("login");
		String motdepasse=request.getParameter("motdepasse");
		
		
		Userservice us=new Userservice();
		if(us.findByemail(email)){
			String msg1="Cette adresse e-mail est déjà utilisée";
			request.setAttribute("msg", msg1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if(us.findBylogin(login)) {
			
			String msg1="Ce nom d'utilisateur est déjà utilisé";
			request.setAttribute("msg", msg1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
		
		User user=new User(nom,prenom,email,telephone,entreprise,login,motdepasse);
		us.create(user);
		User e=us.findUser(login);
		
		HttpSession s=request.getSession();
		s.setAttribute("user",e);
		//request.setAttribute("nom",nom);
		//request.setAttribute("prenom",prenom);
	
		request.getRequestDispatcher("Home.jsp").forward(request, response);
		
	}
	
        //String session = (String)request.getSession().getAttribute("login");
		//request.getRequestDispatcher("Home.jsp").forward(request, response);
	
		//Enqueteservice es=new Enqueteservice();
		//es.findALL();

		//request.setAttribute("List", l);
		//request.getRequestDispatcher("home.jsp?l="+l).forward(request, response);
    	

        
		
		
		
		
	}

}
