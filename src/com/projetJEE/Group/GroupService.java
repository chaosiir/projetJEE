package com.projetJEE.Group;

import com.projetJEE.User.User;
import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    Group getGroupByID(int ID);
    Group getGroupByName(String name);
    void newGroup(Group group);
}
