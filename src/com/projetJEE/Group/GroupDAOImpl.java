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
    public void create(Group group) {
        String query = "insert into `Group` (name, ID_owner, creationDate) values (?, ?, ?)";
        executeUpdateQuery(query,
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
        return group;
    }

    @Override
    public Group findByName(String name) {
        String query = "select * from `Group`, User where name=? and ID_owner=ID_user";
        Group group = getUniqueEntryFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, name);
        });
        addStudents(group);
        return group;
    }

    @Override
    public void addStudent(Group group, Student student) {
        String query = "insert into IncludedStudent values (?, ?)";
        executeUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
            preparedStatement.setString(2, student.getID());
        });
        group.addStudent(student);
    }

    @Override
    public void removeStudent(Group group, Student student) {
        String query = "delete from IncludedStudent where ID_group=? and ID_student=?";
        executeUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, group.getID());
            preparedStatement.setString(2, student.getID());
        });
        group.removeStudent(student);
    }

    @Override
    public void update(Group group) {
        String query = "update `Group` set " +
                "name=?, " +
                "ID_owner=?, " +
                "creationDate=? " +
                "where ID_group=?";
        executeUpdateQuery(query, preparedStatement -> {
            buildGroupStatement(group, preparedStatement);
            preparedStatement.setInt(4, group.getID());
        });
    }

    @Override
    public void delete(Group group) {
        String query = "delete from `Group` where ID_group=?";
        executeUpdateQuery(query, preparedStatement -> {
            preparedStatement.setInt(0, group.getID());
        });
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
}
