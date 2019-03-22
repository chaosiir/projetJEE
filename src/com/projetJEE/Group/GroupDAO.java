package com.projetJEE.Group;

import java.util.List;

public interface GroupDAO {
    List<Group> findAll();
    Group findByID(int ID_group);
    Group findByName(String name);
    void createGroup(String name);
}