package com.projetJEE.Servlet;

import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        System.out.println( request.getParameter("pwd"));
        User us=new User(request.getParameter("id"),request.getParameter("pwd"),request.getParameter("Q"),request.getParameter("Answ"), User.Rights.USER);
        UserServiceImpl usimp=new UserServiceImpl();
        usimp.newUser(us);
        response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/register.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
