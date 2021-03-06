package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.User.User;
import java.util.List;

public interface GroupService {
    boolean newGroup(Group group);
    Group cloneGroup(Group group, String new_name, User new_owner);
    List<Group> getAllGroups();
    List<Group> getGroupsByOwner(User owner);
    List<Group> getGroupsWithStudent(Student student);
    Group getGroupByID(int ID);
    Group getGroupByName(String name);
    boolean addStudentToGroup(Group group, Student student);
    boolean removeStudentFromGroup(Group group, Student student);
    boolean addGroupToGroup(Group group, Group parent);
    boolean removeGroupFromGroup(Group group, Group parent);
    boolean updateGroup(Group group);
    boolean deleteGroup(Group group);
}
