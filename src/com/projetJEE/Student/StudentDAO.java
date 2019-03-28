package com.projetJEE.Student;

import java.util.List;

public interface StudentDAO {
    void insert(Student student);
    List<Student> findAll();
    Student findByID(String ID);
    void update(Student student);
    void delete(Student student);
}
