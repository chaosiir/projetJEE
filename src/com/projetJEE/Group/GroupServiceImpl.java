package com.projetJEE.Group;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private GroupDAO groupDAO = new GroupDAOImpl();

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.findAll();
    }

    @Override
    public Group getGroupByID(int ID) {
        return groupDAO.findByID(ID);
    }

    @Override
    public Group getGroupByName(String name) {
        return groupDAO.findByName(name);
    }

    @Override
    public void newGroup(String name) {
        groupDAO.createGroup(name);
    }
}
