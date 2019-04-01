package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentDAOImpl;
import com.projetJEE.Student.StudentServiceImpl;
import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private static GroupServiceImpl instance;

    public static GroupServiceImpl getInstance() {
        if (instance == null) {
            synchronized (GroupServiceImpl.class) {
                instance = new GroupServiceImpl();
            }
        }
        return instance;
    }

    private GroupDAO groupDAO = new GroupDAOImpl(new UserDAOImpl(), new StudentDAOImpl());

    @Override
    public void newGroup(Group group) { groupDAO.create(group); }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.findAll();
    }

    @Override
    public List<Group> getGroupsByOwner(User owner) { return groupDAO.findByOwner(owner); }

    @Override
    public Group getGroupByID(int ID) {
        return groupDAO.findByID(ID);
    }

    @Override
    public Group getGroupByName(String name) {
        return groupDAO.findByName(name);
    }

    @Override
    public void addStudentToGroup(Group group, Student student) { groupDAO.addStudent(group, student); }

    @Override
    public void removeStudentFromGroup(Group group, Student student) { groupDAO.removeStudent(group, student); }

    @Override
    public void updateGroup(Group group) { groupDAO.update(group); }

    @Override
    public void deleteGroup(Group group) { groupDAO.update(group); }
}
