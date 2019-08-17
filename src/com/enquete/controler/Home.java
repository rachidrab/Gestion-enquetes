package com.enquete.controler;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enquete.beans.Enquete;
import com.enquete.beans.User;
import com.enquete.service.Enqueteservice;



/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			try {
				User e=(User) request.getSession().getAttribute("user");
				
				//request.setAttribute("user",e);
				
				List<Enquete> l;
				Enqueteservice es=new Enqueteservice();
				l=es.findALLU(e.getIdU());
				request.setAttribute("List", l);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				
			}
			
			
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
