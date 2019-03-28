package com.projetJEE.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupDAOMockImpl implements GroupDAO {

    @Override
    public List<Group> findAll() {
        List<Group> groups = new ArrayList<Group>();
        groups.add(new Group(0, "groupe_1"));
        groups.add(new Group(0, "groupe_2"));
        return groups;
    }

    @Override
    public Group findByID(int ID) {
        return new Group(ID, "groupe_" + ID);
    }

    @Override
    public Group findByName(String name) {
        return new Group(0, "name");
    }

    @Override
    public void createGroup(String name) {

    }
}
