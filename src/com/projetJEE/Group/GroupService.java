package com.projetJEE.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupByID(int ID_group);
    Group getGroupByName(String name);
    void newGroup(String name);
}
