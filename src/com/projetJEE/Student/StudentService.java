package com.projetJEE.Student;

import java.util.List;

public interface StudentService {
    void insertStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentByID(String ID);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
