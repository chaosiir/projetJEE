package com.projetJEE.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl instance;

    public static StudentServiceImpl getInstance() {
        if (instance == null) {
            synchronized (StudentServiceImpl.class) {
                instance = new StudentServiceImpl();
            }
        }
        return instance;
    }

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void insertStudent(Student student) {
        studentDAO.insert(student);
    }

    @Override
    public List<Student> getAllStudents() { return studentDAO.findAll(); }

    @Override
    public Student getStudentByID(String ID) {
        return studentDAO.findByID(ID);
    }

    @Override
    public void updateStudent(Student student) { studentDAO.update(student); }

    @Override
    public void deleteStudent(Student student) { studentDAO.delete(student); }
}
