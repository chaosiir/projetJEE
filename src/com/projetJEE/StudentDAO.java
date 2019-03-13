package com.projetJEE;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    List<Student> findByID(String ID);
    void insert(Student student);
    void insertAll(Student[] students);
}
