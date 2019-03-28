package com.projetJEE.Group;

import com.projetJEE.User.User;
import java.util.List;

public interface GroupService {
    void newGroup(Group group);
    List<Group> getAllGroups();
    List<Group> getGroupsByOwner(User owner);
    Group getGroupByID(int ID);
    Group getGroupByName(String name);
    void updateGroup(Group group);
    void deleteGroup(Group group);
}
