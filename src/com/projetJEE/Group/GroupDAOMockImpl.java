package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;

import java.util.ArrayList;
import java.util.List;

public class GroupDAOMockImpl implements GroupDAO {

    @Override
    public boolean create(Group group) { return false; }

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
    public List<Group> findByParent(Group parent) { return new ArrayList<>(); }

    @Override
    public Group findByID(int ID) {
        return new Group("group" + ID, null);
    }

    @Override
    public Group findByName(String name) {
        return new Group(name, null);
    }

    @Override
    public boolean addStudent(Group group, Student student) { return false; }

    @Override
    public boolean removeStudent(Group group, Student student) { return false; }

    @Override
    public boolean addGroup(Group group, Group parent) { return false; }

    @Override
    public boolean removeGroup(Group group, Group parent) { return false; }

    @Override
    public boolean excludeStudent(Group group, Student student) { return false; };

    @Override
    public boolean update(Group group) { return false; }

    @Override
    public boolean delete(Group group) { return false; }

}
