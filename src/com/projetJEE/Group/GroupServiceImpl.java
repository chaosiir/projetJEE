package com.projetJEE.Group;

import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO = new GroupDAOImpl(new UserDAOImpl());

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
    public void updateGroup(Group group) { groupDAO.update(group); }

    @Override
    public void deleteGroup(Group group) { groupDAO.update(group); }
}
