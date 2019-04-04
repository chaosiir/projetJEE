package com.projetJEE.Servlet;


import com.projetJEE.ServletUtils;
import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Students", urlPatterns = {"/Students"})
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print(this.getClass().getName()+" post");
        StudentServiceImpl service = StudentServiceImpl.getInstance();

        String id = request.getParameter("modify");
        if(id!=null){
            System.out.println(" modify");
            String pageName = "/Students/modify";
            ServletUtils.forwardTo(this, request, response, pageName);
            return;
        }
        id = request.getParameter("delete");
        if(id!=null){
            System.out.println(" delete");
            service.deleteStudent(service.getStudentByID(id));
            doGet(request,response);
            return;
        }

        System.out.println();

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(this.getClass().getName()+" get");

        String filter = request.getParameter("filter");
        String value = request.getParameter("value");
        request.setAttribute("pageName","/Students.jsp");
        if(filter!=null && value!=null) {
            System.out.println("search for " + filter + "=" + value);
            StudentServiceImpl service = StudentServiceImpl.getInstance();
            List<Student> students = service.getStudentsByAttribute(filter, value);
            request.setAttribute("students", students);
            request.setAttribute("resetButton", true);
            ServletUtils.forwardTo(this, request, response, "/Students.jsp");
            return;
        }
        request.setAttribute("students", StudentServiceImpl.getInstance().getAllStudents());
        ServletUtils.forwardTo(this, request, response, "/Students.jsp");
    }
}
