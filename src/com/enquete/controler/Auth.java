package com.enquete.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.enquete.beans.Enquete;
import com.enquete.beans.User;
import com.enquete.service.Enqueteservice;
import com.enquete.service.Userservice;

/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
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
		String login = request.getParameter("login");
		String mpU = request.getParameter("motdepasse");
		Userservice us2=new Userservice();
		
		if(us2.findBylogin(login, mpU)) {
			
			User e=us2.findUser(login);
			HttpSession s=request.getSession();
			/*s.setAttribute("user",e);
			List<Enquete> l;
			Enqueteservice es=new Enqueteservice();
			l=es.findALL();	
			request.setAttribute("List", l);*/
			s.setAttribute("user",e);
//.getRequestDispatcher("/Home").forward(request, response);
			response.sendRedirect("Home");
	}else {
		String msg="Login ou mot de passe invalide";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
		
	}

}
