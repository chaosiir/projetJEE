package com.projetJEE.Servlet;


import com.projetJEE.Group.Group;
import com.projetJEE.Group.GroupServiceImpl;
import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Style;
import java.io.IOException;

@WebServlet(name = "Groupmodif", urlPatterns = {"/Group/modify"})
public class GroupmodifyServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroupServiceImpl bs = GroupServiceImpl.getInstance();
		StudentServiceImpl ss = StudentServiceImpl.getInstance();
		String removes = request.getParameter("removes");
		String removeg = request.getParameter("removeg");
		String include = request.getParameter("include");
		Group group = (Group) request.getSession().getAttribute("group");

		if (request.getParameter("validate") != null) {
			String newName = request.getParameter("Name");
			if (newName != null) {
				System.out.println(group +" "+newName);
				group.setName(newName);
				bs.updateGroup(group);
			}
			response.sendRedirect(request.getContextPath()+"/Groups");
			return;

		} else if (request.getParameter("addstudent") != null) {
			String sid = request.getParameter("studentid");
			Student st=ss.getStudentByID(sid);
			if (!sid.isEmpty() && st!=null)
				bs.addStudentToGroup(group,st);
		}
		else if (request.getParameter("addgroup")!=null && request.getParameter("groupid")!=null){
			int id=Integer.parseInt(request.getParameter("groupid"));
			System.out.println(id);
			Group ch=bs.getGroupByID(id);
			if(ch!=null && ch.getID()!=group.getID()){
				bs.addGroupToGroup(ch,group);
			}


		}
		else if(include!=null){
			bs.addStudentToGroup(group,ss.getStudentByID(include));
		}
		else if(removeg!=null){
			bs.removeGroupFromGroup(bs.getGroupByID(Integer.parseInt(removeg)),group);
		}
		else if(removes!=null){
			bs.removeStudentFromGroup(group,ss.getStudentByID(removes));
		}
		doGet(request,response);
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageName = "/Groupmodif.jsp";
		HttpSession session=request.getSession();
		GroupServiceImpl bs = GroupServiceImpl.getInstance();
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
