package com.projetJEE.Servlet;


import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
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
            //todo redirect /Students/modify avec l'id du student
            System.err.println("need modify -> "+id);
        }
        id = request.getParameter("delete");
        if(id!=null){
            StudentServiceImpl service = StudentServiceImpl.getInstance();
            service.deleteStudent(service.getStudentByID(id));
        }
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get "+request.getContextPath());
        System.out.println("get "+request.getServletPath());
        System.out.println("get "+request.getPathInfo());
        System.out.println("get "+request.getPathTranslated());
        String pageName = "/Students.jsp";
        StudentService bs = new StudentServiceImpl();
        request.setAttribute("students", bs.getAllStudents());
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
