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

@WebServlet(name = "Mdp", urlPatterns = {"/mdp"})
public class MdpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");

        User us=new User(request.getParameter("id"),request.getParameter("id"),request.getParameter("id"),request.getParameter("id"), User.Rights.USER);
        String x=request.getParameter("answer");
        System.out.println(x);
     //   String y=us.getAnswerHash();
        String y="Bonjour"; //exemple
        System.out.println(y);
        String x1= UserServiceImpl.getInstance().hash(x);
        if (x1.equals(y)){
            System.out.println("verification ok");
        }
        else{
            System.out.println("non");
            //  response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/login");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Mdp.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
