package com.enquete.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enquete.beans.Enquete;
import com.enquete.beans.Option;
import com.enquete.beans.Question;
import com.enquete.beans.Type;
import com.enquete.beans.User;
import com.enquete.service.Enqueteservice;
import com.enquete.service.Optionservice;
import com.enquete.service.Questionservice;
import com.enquete.service.Typeservice;

/**
 * Servlet implementation class Ques
 */
@WebServlet("/Ques")
public class Ques extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ques() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User e=(User) request.getSession().getAttribute("user");
		List<Type> t;
		Typeservice es=new Typeservice();
		t=es.findALL();
		request.setAttribute("List", t);
		int idE = Integer.parseInt(request.getParameter( "Id" ));
		
		Enqueteservice en=new Enqueteservice();
		Enquete n=en.findById(idE);
		int nbrq=n.getNbQuestions();
		
		request.setAttribute("idE", idE);
		
			request.getRequestDispatcher("Ques.jsp").forward(request, response);
			
		
	
		
		
		
		//request.setAttribute("user",e);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idE = Integer.parseInt(request.getParameter( "Id" ));
		String titre = request.getParameter("titre");
		String type=request.getParameter("type");
		Typeservice es=new Typeservice();
		
		Type t;
		t=es.findByTitre(type);
		
		
		Question q=new Question(titre,idE,t.getIdType());
		Questionservice qs=new Questionservice();
		
		qs.create(q);
		Question Q=qs.findByTitle(idE,titre);
		
		
		
		Optionservice pt=new Optionservice();
		
		
		
		 String[] splitArray = null; //tableau de chaînes
		  //la chaîne à traiter
		 String opt =request.getParameter("opt");;

		  // On découpe la chaîne "str" à traiter et on récupère le résultat dans le tableau "splitArray"
		  splitArray = opt.split(",");
		  
		  
		  for(int i = 0; i<splitArray.length;i++){
			   // On affiche chaque élément du tableau
			   System.out.println("élement n° " + i + "=[" + splitArray[i]+"]");
			   
			   
			   Option p=new Option(splitArray[i],Q.getIdQues());
			   pt.create(p);
			   
		  
		  }

		
		boolean i =qs.create(q);
	
		
		if(i) {
			String msg3="Opération terminée avec succès";
			request.setAttribute("msg3", msg3);
			request.getRequestDispatcher("Ques.jsp").forward(request, response);
			
			
			
		}else {
			
			String msg2="La creation de la question a echoué";
			request.setAttribute("msg2", msg2);
			request.getRequestDispatcher("Ques.jsp").forward(request, response);
		}

		
		
	
		
	
	
	}
		
		

}
