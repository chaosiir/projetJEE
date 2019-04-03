package com.projetJEE.Servlet;


import com.google.gson.Gson;
import com.projetJEE.ServletUtils;
import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentService;
import com.projetJEE.Student.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Students_modify", urlPatterns = {"/Students/modify"})
public class StudentModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.print(this.getClass().getName()+" post");
        String id = request.getParameter("modify");
        if(id!=null){
            System.out.println(" modify");
            StudentService bs = StudentServiceImpl.getInstance();
            request.setAttribute("student", bs.getStudentByID(id));
            String pageName = "/StudentsModify.jsp";
            ServletUtils.forwardTo(this, request, response, pageName);
            return;
        }
        id = request.getParameter("validate");
        if(id!=null){
            System.out.println(" validate");
            String ID = request.getParameter("ID");
            String gender = request.getParameter("gender");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String birthday1 = request.getParameter("birthday");
            System.out.println("get modify birthday : "+new Gson().toJson(request.getParameterMap()));
            Date birthday = null;
            try {
                birthday = new SimpleDateFormat("YYYY-MM-DD").parse(birthday1);
            } catch (ParseException e) { e.printStackTrace(); }
            String bac = request.getParameter("bac");
            int bacYear = Integer.valueOf(request.getParameter("bacYear"));
            String bacGrade = request.getParameter("bacGrade");
            String degree = request.getParameter("degree");
            int degreeYear = Integer.valueOf(request.getParameter("degreeYear"));
            String degreeCity = request.getParameter("degreeCity");
            int registrationYear = Integer.valueOf(request.getParameter("registrationYear"));
            String emailPro = request.getParameter("emailPro");
            String emailPer = request.getParameter("emailPer");
            Student student = new Student(ID, gender, firstname, lastname, birthday, bac, bacYear, bacGrade, degree, degreeYear, degreeCity, registrationYear, emailPro, emailPer);
            StudentService bs = StudentServiceImpl.getInstance();
            boolean done = bs.updateStudent(student);
            if(done)
                System.out.println("update of : "+student);
            else
                System.out.println("didn't update : "+student);
            String pageName = "/Students";
            ServletUtils.forwardTo(this, request, response, pageName);
            return;
        }
        System.out.println();
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(this.getClass().getName()+" get");
        String pageName = "/StudentsModify.jsp";
        ServletUtils.forwardTo(this, request, response, pageName);
    }
}
