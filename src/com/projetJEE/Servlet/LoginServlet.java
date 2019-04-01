package com.projetJEE.Servlet;

import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        System.out.println("LoginServlet constr");
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        System.out.println("Session : "+session);
        if (session==null) {
            String pageName = "/Login.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
            rd.forward(request, response);
        } else {
            response.sendRedirect("./Home");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("post");
        UserServiceImpl usimp=new UserServiceImpl();
        User verif=usimp.getUserByLogin(request.getParameter("inputID"));
        if(verif.getPwdHash().compareTo(usimp.hash(request.getParameter("inputPassword")))==0){
			HttpSession session = request.getSession();
			session.setAttribute("Id",verif.getID());
			session.setAttribute("Name",verif.getLogin());
			response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/Home");
		}
   		else {
			String pageName = "/Login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
			rd.forward(request, response);
		}
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Login.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}