package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;
import java.util.List;

public interface GroupService {
    boolean newGroup(Group group);
    List<Group> getAllGroups();
    List<Group> getGroupsByOwner(User owner);
    Group getGroupByID(int ID);
    Group getGroupByName(String name);
    boolean addStudentToGroup(Group group, Student student);
    boolean removeStudentFromGroup(Group group, Student student);
    boolean updateGroup(Group group);
    boolean deleteGroup(Group group);
}
