package com.projetJEE.Servlet;


import com.projetJEE.Group.Group;
import com.projetJEE.Group.GroupServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Groupmodif", urlPatterns = {"/Group/modify"})
public class GroupmodifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = "/Groupmodif.jsp";
		HttpSession session=request.getSession();
		GroupServiceImpl bs = new GroupServiceImpl();
		session.setAttribute("group", bs.getGroupByID((int)session.getAttribute("grouptomodify")));
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
