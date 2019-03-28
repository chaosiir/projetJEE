package com.projetJEE.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    Student findByID(String ID);
    void insert(Student student);
    void insertAll(Student[] students);
    void delete(Student student);
}
