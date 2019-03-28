package com.projetJEE.Group;

import com.projetJEE.User.User;

import java.util.List;

public interface GroupDAO {
    List<Group> findAll();
    Group findByID(int ID);
    //Group findByOwner(User owner);
    Group findByName(String name);
    void createGroup(Group group);
}