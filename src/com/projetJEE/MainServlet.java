package com.projetJEE;

import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;
import com.projetJEE.Student.StudentWS;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "Main", urlPatterns = {"/"})
public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() throws ParseException {
        super();
        System.out.println("MainServlet constr");

        /* Decomment these lines to initialize database with web service */
//        Student[] students = StudentWS.getAllStudents();
//        StudentService studentService = new StudentServiceImpl();
//        studentService.insertStudents(students);
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
            StudentService bs = new StudentServiceImpl();
            request.setAttribute("students", bs.getAllStudents());
            rd.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}