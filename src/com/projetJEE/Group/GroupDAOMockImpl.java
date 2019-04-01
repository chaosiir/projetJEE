package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupDAOMockImpl implements GroupDAO {

    @Override
    public void create(Group group) { }

    @Override
    public List<Group> findAll() {
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group("group_0", null));
        groups.add(new Group("group_1", null));
        return groups;
    }

    @Override
    public List<Group> findByOwner(User owner) {
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group("group_0", owner));
        groups.add(new Group("group_1", owner));
        return groups;
    }

    @Override
    public Group findByID(int ID) {
        return new Group("group" + ID, null);
    }

    @Override
    public Group findByName(String name) {
        return new Group(name, null);
    }

    @Override
    public void addStudent(Group group, Student student) {}

    @Override
    public void removeStudent(Group group, Student student) { }

    @Override
    public void update(Group group) { }

    @Override
    public void delete(Group group) { }

}
