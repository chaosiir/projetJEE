package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;

import java.util.List;

public interface GroupDAO {
    boolean create(Group group);
    List<Group> findAll();
    List<Group> findByParent(Group parent);
    List<Group> findByOwner(User owner);
    Group findByID(int ID);
    Group findByName(String name);
    boolean addStudent(Group group, Student student);
    boolean removeStudent(Group group, Student student);
    boolean addGroup(Group group, Group parent);
    boolean removeGroup(Group group, Group parent);
    boolean excludeStudent(Group group, Student student);
    boolean update(Group group);
    boolean delete(Group group);
}