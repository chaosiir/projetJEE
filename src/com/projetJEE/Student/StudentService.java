package com.projetJEE.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getStudentByID(String ID);
    void insertStudent(Student student);
   //void deleteStudent(Student student);
    void insertStudents(Student[] students);
}
