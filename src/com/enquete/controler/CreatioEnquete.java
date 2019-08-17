package com.enquete.controler;

import java.io.IOException;
import java.text.ParseException;

import java.time.LocalDate;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enquete.beans.Enquete;
import com.enquete.beans.User;
import com.enquete.service.Enqueteservice;

/**
 * Servlet implementation class CreatioEnquete
 */
@WebServlet("/CreationEnquete")
public class CreatioEnquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatioEnquete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User e=(User) request.getSession().getAttribute("user");
		request.getRequestDispatcher("CreationEnq.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//surround below line with try catch block as below code throws checked exception
		try {
			User e=(User) request.getSession().getAttribute("user");
			String titre = request.getParameter("titre");
			String description =request.getParameter("description");
			LocalDate dateDebut=LocalDate.parse(request.getParameter("dateDebut"));
			LocalDate dateFin=LocalDate.parse(request.getParameter("dateFin"));
			String etat=null;
		
			
			int nbQuestions=Integer.parseInt(request.getParameter("nbQuestions"));
			
			
			
			Enquete enquete=new Enquete(titre,description,dateDebut,dateFin,etat,nbQuestions,e.getIdU());
			
			Enqueteservice us=new Enqueteservice();
			
			boolean i =us.create(enquete);
			
			
			if(i) {
				String msg3="Opération terminée avec succès";
				request.setAttribute("msg3", msg3);
				request.getRequestDispatcher("CreationEnq.jsp").forward(request, response);
				
				
				
			}else {
				
				String msg2="La creation de l'enquet a echoué";
				request.setAttribute("msg2", msg2);
				request.getRequestDispatcher("CreationEnq.jsp").forward(request, response);
			}

			
			
			
			
		

} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}}
