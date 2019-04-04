package com.projetJEE.Student;

import java.util.List;

public interface StudentService {
    boolean insertStudent(Student student);
    List<Student> getAllStudents();
    List<Student> getStudentsByAttribute(String attribute, String value);
    Student getStudentByID(String ID);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
}
