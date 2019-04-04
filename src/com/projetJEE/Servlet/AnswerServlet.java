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

        HttpSession session = request.getSession(false);

        UserServiceImpl usimp=new UserServiceImpl();
        User user=usimp.getUserByLogin(request.getParameter("id"));


        System.out.println(user.getQuestion());
        String answer = request.getParameter("answer");
        System.out.println(answer);

       if(user.getAnswerHash().equals(usimp.hash(answer))){
            System.out.println("verification ok");
            session.setAttribute("user", user);
            session.setAttribute("auth", true);

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
        User user = (User) request.getSession(false).getAttribute("user");
        request.setAttribute("question", user.getQuestion());
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        rd.forward(request, response);
    }
}
