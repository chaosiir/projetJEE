package com.projetJEE.Servlet;


import com.projetJEE.ServletUtils;
import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Students_modify", urlPatterns = {"/Students/modify"})
public class StudentModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("modify");
        if(id!=null){
            StudentService bs = StudentServiceImpl.getInstance();
            request.setAttribute("student", bs.getStudentByID(id));
            String pageName = "/StudentsModify.jsp";
            ServletUtils.forwardTo(this, request, response, pageName);
            return;
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/StudentsModify.jsp";
        ServletUtils.forwardTo(this, request, response, pageName);
    }
}
