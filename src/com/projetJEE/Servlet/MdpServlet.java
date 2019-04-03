package com.projetJEE.Servlet;
import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Variable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Mdp", urlPatterns = {"/mdp"})

public class MdpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");


        UserServiceImpl usimp=new UserServiceImpl();
        User verif=usimp.getUserByLogin(request.getParameter("id"));
        String question=verif.getQuestion();
        request.setAttribute("question",verif.getQuestion());
        getServletContext().getRequestDispatcher("/Answer.jsp").forward(request, response);


        System.out.println(verif.getQuestion());

        response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/answer");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Mdp.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
