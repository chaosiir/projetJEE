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

        UserServiceImpl usimp = UserServiceImpl.getInstance();
        User verif=usimp.getUserByLogin(request.getParameter("inputID"));

        System.out.println(verif.getQuestion()); // Test to see what is the question before update
        System.out.println(verif.getPwdHash()); //  Test to see what is the hashed pass before update


        verif.setLogin(request.getParameter("inputID"));                       //set new login
        verif.setPwdHash(usimp.hash(request.getParameter("inputPassword")));   //set new password
        verif.setQuestion(request.getParameter("inputQ"));                     //set new question
        verif.setAnswerHash(usimp.hash(request.getParameter("answer")));       //set new answer


        usimp.updateUser(verif);  // update the user



        System.out.println(verif.getQuestion());// Test to see what is the question after update
        System.out.println(verif.getPwdHash());//  Test to see what is the hashed pass after update

        response.sendRedirect(request.getContextPath()+"/Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Update.jsp";
        System.out.println("get");
        User usermod=(User) request.getAttribute("userAmodifier");
        if(usermod!=null){
            request.getSession().setAttribute("userAmodifier",usermod);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
