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
import java.io.PrintWriter;

@WebServlet(name = "Mdp", urlPatterns = {"/mdp"})
public class MdpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");

       // User us=new User(request.getParameter("id"),request.getParameter("id"),request.getParameter("id"),request.getParameter("id"), User.Rights.USER);
        UserServiceImpl usimp=new UserServiceImpl();
        User verif=usimp.getUserByLogin(request.getParameter("id"));
     // System.out.println(verif.getQuestion());
        if(verif.getAnswerHash().equals(usimp.hash(request.getParameter("answer")))){
            System.out.println("verification ok");
            PrintWriter out = response.getWriter();

            response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/update");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Verification ok');");
            out.println("</script>");
        }
        else {
            System.out.println("non");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('answer incorrect');");
            out.println("</script>");
            //response.sendRedirect("http://localhost:8080/projetJEE_war_exploded/login");


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Mdp.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
