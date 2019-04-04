package com.projetJEE.Servlet;

import com.projetJEE.User.User;
import com.projetJEE.User.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Mdp", urlPatterns = {"/mdp"})
public class MdpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("mdp post");

        UserServiceImpl usimp=UserServiceImpl.getInstance();
        User user=usimp.getUserByLogin(request.getParameter("id"));
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        System.out.println("mdp question:"+user.getQuestion());

        response.sendRedirect(request.getContextPath()+"/answer");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Mdp.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
