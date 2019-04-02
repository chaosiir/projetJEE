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

@WebServlet(name = "Update", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        UserServiceImpl usimp=new UserServiceImpl();
        User verif=usimp.getUserByLogin(request.getParameter("inputID"));
        System.out.println(verif.getQuestion()); // Test to see what is the question before update
        System.out.println(verif.getPwdHash()); //Test to see what is the hashed pass before update

        usimp.deleteUser(verif);//we delete the first account
        User us=new User(request.getParameter("inputID"),request.getParameter("inputPassword"),request.getParameter("inputQ"),request.getParameter("answer"), User.Rights.USER);
        UserServiceImpl usimp1=new UserServiceImpl();
        usimp1.newUser(us);

        System.out.println(us.getQuestion());// Test to see what is the question after update
        System.out.println(us.getPwdHash());// Test to see what is the hashed pass after update

        response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Update.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
