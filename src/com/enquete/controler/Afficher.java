package com.enquete.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enquete.beans.Option;
import com.enquete.beans.Question;
import com.enquete.service.Optionservice;
import com.enquete.service.Questionservice;

/**
 * Servlet implementation class Afficher
 */
@WebServlet("/Afficher")
public class Afficher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Afficher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idE =Integer.parseInt(request.getParameter( "Id" ));
		//int idQ =Integer.parseInt(request.getParameter( "Idq" ));
		Questionservice qs= new Questionservice();
		Optionservice os=new Optionservice();
		
		List<Question> l =qs.findALL(idE);
		
		Question q=l.get(0);
		System.out.println(q.getIdType());
		System.out.println("L id de question est "+q.getIdQues());
		if(q.getIdType()==3) {// choix multiple
			System.out.println("c'est un choix multiple");
			List<Option> o =os.findALL(q.getIdQues());
			int t=3;
			request.setAttribute("nm",0);//numero de la premier quest
			request.setAttribute("t",t);
			request.setAttribute("o",o);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
			//response.sendRedirect("affqst.jsp");
		} else if(q.getIdType()==4) { // choix unique
			System.out.println("c'est un choix multiple");
			List<Option> o =os.findALL(q.getIdQues());
			int t=4;
			request.setAttribute("t",t);
			request.setAttribute("o",o);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
	
		}else if(q.getIdType()==1){
			
			System.out.println("c'est un text");
			int t=1;
			request.setAttribute("t",t);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idQ =Integer.parseInt(request.getParameter( "iq" ));//get Id of current question
		int nm=Integer.parseInt(request.getParameter( "nm" ));//index of current question 
		
		Questionservice qs= new Questionservice();
		Optionservice os=new Optionservice();
		
		Question q=qs.findById(idQ);
		
		if(q.getIdType()==3) {// choix multiple
			String[] ch=request.getParameterValues("listeo");
			for(int i=0;i<ch.length;i++) {
				System.out.println("l'option true"+ch[0]);
			}
			
			System.out.println("c'est un choix multiple");
			List<Option> o =os.findALL(q.getIdQues());
			int t=3;
			request.setAttribute("t",t);
			request.setAttribute("o",o);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
			//response.sendRedirect("affqst.jsp");
		} else if(q.getIdType()==4) { // choix unique
			System.out.println("c'est un choix multiple");
			List<Option> o =os.findALL(q.getIdQues());
			int t=4;
			request.setAttribute("t",t);
			request.setAttribute("o",o);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
	
		}else if(q.getIdType()==1){
			
			System.out.println("c'est un text");
			int t=1;
			request.setAttribute("t",t);
			request.setAttribute("q",q);
			request.getRequestDispatcher("affqst.jsp").forward(request, response);
		}
		
		
		
		
		
	}

}
