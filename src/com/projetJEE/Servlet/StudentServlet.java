package com.projetJEE.Servlet;


import com.projetJEE.ServletUtils;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Students", urlPatterns = {"/Students"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("modify");
        if(id!=null){
            System.err.println("need modify -> "+id);
            String pageName = "/StudentsModify";
            ServletUtils.forwardTo(this, request, response, pageName);
            return;
        }
        id = request.getParameter("delete");
        if(id!=null){
            StudentServiceImpl service = StudentServiceImpl.getInstance();
            service.deleteStudent(service.getStudentByID(id));
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Students.jsp";
        request.setAttribute("students", StudentServiceImpl.getInstance().getAllStudents());
        ServletUtils.forwardTo(this, request, response, pageName);
    }
}
