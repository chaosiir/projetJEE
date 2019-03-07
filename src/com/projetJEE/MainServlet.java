package com.projetJEE;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/com.projetJEE.MainServlet")
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        System.out.println("MainServlet constr");
        String json = WebServiceGetter.jsonGetRequest("https://stormy-lowlands-39083.herokuapp.com/etudiants/");
        Gson gson = new Gson();
        Student[] students = gson.fromJson(json, Student[].class);
        for (Student s : students) {
            System.out.println(s);
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO Auto-generated method stub
        doProcess(request, response);
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
        String pageName = "/accueil.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
        try {
            BookService bs = new BookServiceImpl();
            request.setAttribute("listBooks", bs.getAllBooks());
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}