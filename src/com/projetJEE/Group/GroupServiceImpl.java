package com.projetJEE.Group;

import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentDAOImpl;
import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private static GroupServiceImpl instance;

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

    private GroupDAO groupDAO = new GroupDAOImpl(new UserDAOImpl(), new StudentDAOImpl());

    /**
     * Creates a group
     * @param group Group to create
     * @pre group.getID() == -1
     * @post group.getID() != -1
     */
    @Override
    public void newGroup(Group group) { groupDAO.create(group); }

    /**
     * Returns all groups
     * @return A list of groups
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
     */
    @Override
    public Group getGroupByID(int ID) {
        return groupDAO.findByID(ID);
    }

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
     */
    @Override
    public void addStudentToGroup(Group group, Student student) { groupDAO.addStudent(group, student); }

    /**
     * Removes a student from a group
     * @param group Group where the student is removed
     * @param student Student to remove
     */
    @Override
    public void removeStudentFromGroup(Group group, Student student) { groupDAO.removeStudent(group, student); }

    /**
     * Updates a group
     * @param group Group to update
     * Only owner, name and creation date can be updated
     */
    @Override
    public void updateGroup(Group group) { groupDAO.update(group); }

    /**
     * Deletes a group
     * @param group Group to delete
     */
    @Override
    public void deleteGroup(Group group) { groupDAO.update(group); }
}
