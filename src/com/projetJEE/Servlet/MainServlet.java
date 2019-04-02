package com.projetJEE.Servlet;

import com.projetJEE.Group.Group;
import com.projetJEE.Group.GroupService;
import com.projetJEE.Group.GroupServiceImpl;
import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;
import com.projetJEE.Student.StudentWS;
import com.projetJEE.User.User;
import com.projetJEE.User.UserService;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Main", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() throws ParseException {
        super();
        System.out.println("MainServlet constr");

        UserService us = UserServiceImpl.getInstance();
        GroupService gs = GroupServiceImpl.getInstance();
        StudentService ss = StudentServiceImpl.getInstance();


        /* Decomment these lines to initialize database with web service */
//        Student[] students = StudentWS.getAllStudents();
//        for (Student s: students) {
//            ss.insertStudent(s);
//        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Auto-generated method stub
        doProcess(request, response);
        //response.sendRedirect("login");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Auto-generated method stub
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*String pageName = "/Login.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        response.sendRedirect("./login");
    }
}