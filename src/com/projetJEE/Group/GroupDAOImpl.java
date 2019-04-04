package com.projetJEE.Group;

import com.projetJEE.DAOImpl;
import com.projetJEE.Student.Student;
import com.projetJEE.Student.StudentDAOImpl;
import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class GroupDAOImpl extends DAOImpl<Group> implements GroupDAO {

    private UserDAOImpl userDAO;
    private StudentDAOImpl studentDAO;

    public GroupDAOImpl(UserDAOImpl userDAO, StudentDAOImpl studentDAO) {
        this.userDAO = userDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public boolean create(Group group) {
        String query = "insert into `Group` (name, ID_owner, creationDate) values (?, ?, ?)";
        return executeUniqueUpdateQuery(query,
                preparedStatement -> { buildGroupStatement(group, preparedStatement); },
                generatedKeys -> {
                    if (generatedKeys.next()) {
                        group.setID(generatedKeys.getInt(1));
                        System.out.println("Successfully created " + group);
                    } else {
                        throw new SQLException("No ID generated for " + group);
                    }
                });
    }

    @Override
    public List<Group> findAll() {
        String query = "select * from `Group`, User where ID_owner=ID_user";
        return getEntriesFromQuery(query, preparedStatement -> {});
    }

    @Override
    public List<Group> findByOwner(User owner) {
        String query = "select * from `Group`, User where ID_owner=?";
        return getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, owner.getID());
        });
    }

    @Override
    public Group findByID(int ID) {
        String query = "select * from `Group`, User where ID_group=? and ID_owner=ID_user";
        Group group = getUniqueEntryFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, ID);
        });
        addStudents(group);
        addChildren(group);
        addExclusions(group);
        return group;
    }

    @Override
    public Group findByName(String name) {
        String query = "select * from `Group`, User where name=? and ID_owner=ID_user";
        Group group = getUniqueEntryFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, name);
        });
        addStudents(group);
        addChildren(group);
        addExclusions(group);
        return group;
    }

    @Override
    public List<Group> findByParent(Group parent) {
        String query = "select * from `Group`, User where ID_user=? and ID_group in " +
                "(select ID_group_child from IncludedGroup where ID_group=?)";
        List<Group> groups = getEntriesFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, parent.getOwner().getID());
            preparedStatement.setInt(2, parent.getID());
        });
        for (Group g : groups) {
            addStudents(g);
            addChildren(g);
        }
        return groups;
    }

    @Override
    public boolean addStudent(Group group, Student student) {
        String query = "insert into IncludedStudent values (?, ?)";
        boolean added = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
            preparedStatement.setString(2, student.getID());
        });
        if (added) {
            System.out.println("Successfully added student " + student.getID() + " to group " + group.getName());
            group.addStudent(student);
        }
        return added;
    }

    @Override
    public boolean removeStudent(Group group, Student student) {
        String query = "delete from IncludedStudent where ID_group=? and ID_student=?";
        boolean removed = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
            preparedStatement.setString(2, student.getID());
        });
        if (removed) {
            System.out.println("Successfully removed student " + student.getID() + " from group " + group.getName());
            group.removeStudent(student);
        }
        return removed;
    }

    @Override
    public boolean addGroup(Group group, Group parent) {
        String query = "insert into IncludedGroup values (?, ?)";
        boolean added = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, parent.getID());
            preparedStatement.setInt(2, group.getID());
        });
        if (added) {
            System.out.println("Successfully added group " + group.getName() + " to group " + parent.getName());
            parent.addGroup(group);
        }
        return added;
    }

    @Override
    public boolean removeGroup(Group group, Group parent) {
        String query = "delete from IncludedGroup where ID_group=? and ID_group_child=?";
        boolean removed = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, parent.getID());
            preparedStatement.setInt(2, group.getID());
        });
        if (removed) {
            System.out.println("Successfully removed group " + group.getName() + " from group " + parent.getName());
            parent.removeGroup(group);
        }
        return removed;
    }

    @Override
    public boolean excludeStudent(Group group, Student student) {
        String query = "insert into ExcludedStudent values (?, ?)";
        boolean excluded = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setString(1, student.getID());
            preparedStatement.setInt(2, group.getID());
        });
        if (excluded) {
            System.out.println("Successfully excluded student " + student.getID() + " from group " + group.getName());
            group.excludeStudent(student);
        }
        return excluded;
    }

    @Override
    public boolean update(Group group) {
        String query = "update `Group` set " +
                "name=?, " +
                "ID_owner=?, " +
                "creationDate=? " +
                "where ID_group=?";
        boolean updated = executeUniqueUpdateQuery(query, preparedStatement -> {
            buildGroupStatement(group, preparedStatement);
            preparedStatement.setInt(4, group.getID());
        });
        if (updated) {
            System.out.println("Successfully updated " + group);
        }
        return updated;
    }

    @Override
    public boolean delete(Group group) {
        String query = "delete from `Group` where ID_group=?";
        boolean deleted = executeUniqueUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
        });
        if (deleted) {
            System.out.println("Successfully deleted " + group);
        }
        return deleted;
    }

    @Override
    public Group entryFromResultSet(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("ID_group");
        String name = resultSet.getString("name");
        Date date = resultSet.getDate("creationDate");
        User owner = userDAO.entryFromResultSet(resultSet);
        Group group = new Group(name, owner);
        group.setCreationDate(date);
        group.setID(ID);
        return group;
    }

    private void buildGroupStatement(Group group, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, group.getName());
        preparedStatement.setInt(2, group.getOwner().getID());
        preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
    }

    private void addStudents(Group group) {
        group.setStudents(studentDAO.findByGroup(group));
    }

    private void addChildren(Group group) {
        group.setChildren(findByParent(group));
    }

    private void addExclusions(Group group) { group.setExclusions(studentDAO.findByExclusion(group)); }
}
