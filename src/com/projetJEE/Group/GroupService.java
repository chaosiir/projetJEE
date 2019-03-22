package com.projetJEE.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupByID(int ID);
    Group getGroupByName(String name);
    void newGroup(String name);
}
