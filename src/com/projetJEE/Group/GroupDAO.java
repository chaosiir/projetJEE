package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;

import java.util.List;

public interface GroupDAO {
    void create(Group group);
    List<Group> findAll();
    List<Group> findByOwner(User owner);
    Group findByID(int ID);
    Group findByName(String name);
    void addStudent(Group group, Student student);
    void removeStudent(Group group, Student student);
    void update(Group group);
    void delete(Group group);
}