package com.projetJEE.Servlet;


import com.projetJEE.Group.Group;
import com.projetJEE.Group.GroupServiceImpl;
import com.projetJEE.ServletUtils;
import com.projetJEE.Student.StudentServiceImpl;
import com.projetJEE.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Groups", urlPatterns = {"/Groups"})
public class GroupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String modify = request.getParameter("modify");
		System.out.println("modify: "+ modify);
		String delete = request.getParameter("delete");
		System.out.println("delete: "+ delete);
		if(delete !=null) {//delete a group
			GroupServiceImpl bs = GroupServiceImpl.getInstance();
			bs.deleteGroup(bs.getGroupByID(Integer.parseInt(delete)));
			doGet(request, response);
		}
		else if(modify!=null) {//modify a group
			session.setAttribute("grouptomodify",Integer.parseInt(modify));
			response.sendRedirect(request.getContextPath()+"/Group/modify");
		}
		else {//create a group
			Group newgroup=new Group(request.getParameter("Name"),(User) request.getSession().getAttribute("user"));
			GroupServiceImpl bs = GroupServiceImpl.getInstance();
			if(!bs.newGroup(newgroup)){
				System.out.println("alert");
				request.setAttribute("alert","Nom deja pris");
			}
			doGet(request,response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GroupServiceImpl bs = GroupServiceImpl.getInstance();
		StudentServiceImpl ss = StudentServiceImpl.getInstance();
		List<Group> groups;
		String id_student = request.getParameter("ID_student");
		if(id_student !=null) {//id_student a group
			groups = bs.getGroupsWithStudent(ss.getStudentByID(id_student));
			request.setAttribute("forStudent", true);
		}else{
			groups = bs.getAllGroups();
		}


		String pageName = "/Groups.jsp";
		request.setAttribute("groups", groups);
		ServletUtils.forwardTo(this, request,response,pageName);
	}
}
