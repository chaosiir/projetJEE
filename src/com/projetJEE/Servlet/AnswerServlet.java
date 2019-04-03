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

@WebServlet(name = "Answer", urlPatterns = {"/answer"})
public class AnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");

        UserServiceImpl usimp=new UserServiceImpl();
        User verif=usimp.getUserByLogin(request.getParameter("id"));


        System.out.println(verif.getQuestion());
        String x=request.getParameter("answer");
        System.out.println(x);

       if(verif.getAnswerHash().equals(usimp.hash(request.getParameter("answer")))){
            System.out.println("verification ok");

            response.sendRedirect(request.getContextPath()+"/update");

        }
        else {
            System.out.println("non");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('answer incorrect');");
            out.println("</script>");
            response.sendRedirect(request.getContextPath()+"/mdp");


        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageName = "/Answer.jsp";
        System.out.println("get");
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
