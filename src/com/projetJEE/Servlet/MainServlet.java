package com.projetJEE.Servlet;

import com.projetJEE.Group.Group;
import com.projetJEE.Group.GroupService;
import com.projetJEE.Group.GroupServiceImpl;
import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;
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

@WebServlet(name = "Main", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() throws ParseException {
        super();
        System.out.println("MainServlet constr");
        GroupService gs = new GroupServiceImpl();
        UserService us = new UserServiceImpl();

//        User user = new User("login0", "password", "question", "answer", User.Rights.USER);
//        us.newUser(user);
//        Group group = new Group("group_login0", user);
//        gs.newGroup(group);
//
//        user = us.getUserByLogin("login0");
//        System.out.println(user);

        /* Decomment these lines to initialize database with web service */
//        Student[] students = StudentWS.getAllStudents();
//        StudentService studentService = new StudentServiceImpl();
//        studentService.insertStudents(students);
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

    private void doProcess(HttpServletRequest request, HttpServletResponse response) {
        String pageName = "/Login.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            StudentService bs = new StudentServiceImpl();
            request.setAttribute("students", bs.getAllStudents());
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}