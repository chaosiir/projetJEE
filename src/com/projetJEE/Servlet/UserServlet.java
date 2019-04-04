package com.projetJEE.Servlet;


import com.projetJEE.Student.StudentServiceImpl;
import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Users", urlPatterns = {"/Users"})
public class UserServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		UserServiceImpl usimp = UserServiceImpl.getInstance();
		User user=usimp.getUserByID(Integer.parseInt(request.getParameter("delete")));
		usimp.deleteUser(user);


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = "/Users.jsp";
		UserServiceImpl bs = UserServiceImpl.getInstance();
		request.setAttribute("users", bs.getAllUsers());
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
