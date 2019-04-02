package com.projetJEE.Servlet;


import com.projetJEE.Group.GroupServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class GroupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = "/Groups.jsp";
		GroupServiceImpl bs = new GroupServiceImpl();
		request.setAttribute("groups", bs.getAllGroups());
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		// TODO : dans la page recuperer le login de L'Owner et la liste des groups a tester
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
