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

@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class GroupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println("modify: "+ request.getParameter("modify"));
		String delete = request.getParameter("delete");
		System.out.println("delete: "+ delete);
		if(delete !=null) {
			GroupServiceImpl bs = new GroupServiceImpl();
			bs.deleteGroup(bs.getGroupByID(Integer.parseInt(delete)));
			doGet(request, response);
		}
		else {
			session.setAttribute("grouptomodify",Integer.parseInt(request.getParameter("modify")));
			response.sendRedirect(request.getContextPath()+"/Group/modify");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = "/Groups.jsp";
		GroupServiceImpl bs = new GroupServiceImpl();
		request.setAttribute("groups", bs.getAllGroups());
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
