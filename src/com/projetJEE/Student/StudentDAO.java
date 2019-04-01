package com.projetJEE.Student;

import com.projetJEE.Group.Group;

import java.util.List;

public interface StudentDAO {
    void insert(Student student);
    List<Student> findAll();
    List<Student> findByGroup(Group group);
    Student findByID(String ID);
    void update(Student student);
    void delete(Student student);
}
