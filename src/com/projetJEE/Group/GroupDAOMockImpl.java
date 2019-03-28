package com.projetJEE.Group;

import com.projetJEE.User.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupDAOMockImpl implements GroupDAO {

    @Override
    public List<Group> findAll() {
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group("groupe_1", null));
        groups.add(new Group("groupe_2", null));
        return groups;
    }

    @Override
    public Group findByID(int ID) {
        return new Group("groupe_" + ID, null);
    }

    @Override
    public Group findByName(String name) {
        return new Group("name", null);
    }

    @Override
    public void createGroup(Group group) { }
}
