package com.projetJEE.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> getStudentByID(String ID) {
        return studentDAO.findByID(ID);
    }

    @Override
    public void insertStudent(Student student) {
        studentDAO.insert(student);
    }

}
