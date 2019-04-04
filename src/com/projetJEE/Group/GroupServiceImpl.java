package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentDAOImpl;
import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private static GroupServiceImpl instance;

    private StudentDAOImpl studentDAO = new StudentDAOImpl();
    private GroupDAO groupDAO = new GroupDAOImpl(new UserDAOImpl(), studentDAO);

    /**
     * Returns the GroupServiceImpl singleton
     * @return GroupServiceImpl instance
     */
    public static GroupServiceImpl getInstance() {
        if (instance == null) {
            synchronized (GroupServiceImpl.class) {
                instance = new GroupServiceImpl();
            }
        }
        return instance;
    }

    /**
     * Private constructor since it's a singleton
     */
    private GroupServiceImpl() {}

    /**
     * Creates a group
     * @param group Group to create
     * @pre group.getID() == -1
     * @post group.getID() != -1
     * @return The group has been successfully created
     */
    @Override
    public boolean newGroup(Group group) { return groupDAO.create(group); }

    /**
     * Clones a group
     * @param group Group to clone
     * @param new_name Cloned group name
     * @param new_owner Cloned group owner
     * @return The group cloned, null if cloning failed
     * Slow method, must be used wisely
     */
    @Override
    public Group cloneGroup(Group group, String new_name, User new_owner) {
        Group cloned_group = new Group(new_name, new_owner);
        newGroup(cloned_group);
        if (cloned_group.getID() != -1) {
            for (Student s : group.getStudents())
                addStudentToGroup(cloned_group, s);
            for (Group g : group.getChildren())
                addGroupToGroup(g, cloned_group);
            for (Student s : group.getExclusions())
                groupDAO.excludeStudent(cloned_group, s);
            return cloned_group;
        } else {
            return null;
        }
    }

    /**
     * Returns all groups
     * @return A list of groups
     * The list of students and child groups for each group won't be retrieved,
     * use getGroupByID, getGroupByName instead
     */
    @Override
    public List<Group> getAllGroups() {
        return groupDAO.findAll();
    }

    /**
     * Returns groups by owner
     * @param owner Group's owner
     * @return A list of groups with that owner
     */
    @Override
    public List<Group> getGroupsByOwner(User owner) { return groupDAO.findByOwner(owner); }

    /**
     * Returns a group by ID
     * @param ID Group's ID
     * @return The group with that ID or null if nonexistent
     * The list of students and child groups for each group won't be retrieved,
     * use getGroupByID, getGroupByName instead
     */
    @Override
    public Group getGroupByID(int ID) {
        return groupDAO.findByID(ID);
    }

    /**
     * Returns groups with a student
     * @param student The student to look for
     * @return A list of groups containing the student
     */
    @Override
    public List<Group> getGroupsWithStudent(Student student) { return groupDAO.findByStudent(student); }

    /**
     * Returns a group by name
     * @param name Group's name
     * @return The group with that name or null if nonexistent
     */
    @Override
    public Group getGroupByName(String name) {
        return groupDAO.findByName(name);
    }

    /**
     * Adds a student to a group
     * @param group Group where the student is added
     * @param student Student to add
     * @return The student has been successfully added to the group
     */
    @Override
    public boolean addStudentToGroup(Group group, Student student) {
        if (!group.getExclusions().contains(student))
            return groupDAO.addStudent(group, student);
        else
            return groupDAO.removeExclusion(group, student);
    }

    /**
     * Adds a group to another group
     * @param group group to add
     * @param parent source group
     * @return The group has been successfully added to parent
     */
    @Override
    public boolean addGroupToGroup(Group group, Group parent) { return groupDAO.addGroup(group, parent); }

    /**
     * Removes a group from another group
     * @param group group to remove
     * @param parent source group
     * @return The group has been successfully removed from parent
     */
    @Override
    public boolean removeGroupFromGroup(Group group, Group parent) { return groupDAO.removeGroup(group, parent); }

    /**
     * Removes a student from a group
     * @param group Group where the student is removed
     * @param student Student to remove
     * @return The student has been successfully removed from the group
     * Removes the student from the group if it contains directly the student (i.e. not inherited from child group),
     * excludes it otherwise.
     */
    @Override
    public boolean removeStudentFromGroup(Group group, Student student) {
        if (group.getStudents().contains(student))
            return groupDAO.removeStudent(group, student);
        else
            return groupDAO.excludeStudent(group, student);
    }

    /**
     * Updates a group
     * @param group Group to update
     * @return The group has been successfully updated
     * Only owner, name and creation date can be updated
     */
    @Override
    public boolean updateGroup(Group group) { return groupDAO.update(group); }

    /**
     * Deletes a group
     * @param group Group to delete
     * @return The group has been successfully deleted
     */
    @Override
    public boolean deleteGroup(Group group) { return groupDAO.delete(group); }
}
