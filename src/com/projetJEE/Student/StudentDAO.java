package com.projetJEE.Student;

import com.projetJEE.Group.Group;

import java.util.List;

public interface StudentDAO {
    boolean insert(Student student);
    List<Student> findAll();
    List<Student> findByGroup(Group group);
    Student findByID(String ID);
    boolean update(Student student);
    boolean delete(Student student);
}
