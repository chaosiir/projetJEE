package com.projetJEE.Group;

import com.projetJEE.DBManager;
import com.projetJEE.User.User;
import com.projetJEE.User.UserDAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupDAOImpl implements GroupDAO {

    @Override
    public List<Group> findAll() {
        return groupsFromQuery("select * from `Group`, User where ID_owner=ID_user");
    }

    @Override
    public Group findByID(int ID) {
        List<Group> groups = groupsFromQuery("select * from `Group`, User where ID_group=" + ID + " and ID_owner=ID_user");
        return groups.isEmpty() ? null : groups.get(0);
    }

    @Override
    public Group findByName(String name) {
        try {
            String query = "select * from `Group`, User where name=? and ID_owner=ID_user";
            Connection con = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, name);

            ResultSet rs = preparedStatement.executeQuery();
            Group group = groupsFromResultSet(rs).get(0);
            con.close();
            return group;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createGroup(Group group) {
        try {
            String query = " insert into `Group` (name, ID_owner, creationDate) values (?, ?, ?)";
            Connection con = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, group.getName());
            preparedStatement.setInt(2, group.getOwner().getID());
            preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                group.setID(generatedKeys.getInt(1));
                System.out.println("Successfully created group " + group);
            } else {
                throw new SQLException("NO ID GENERATED FOR GROUP");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO : refactor function ___FromQuery
    private List<Group> groupsFromQuery(String query) {
        List<Group> groups = new ArrayList<Group>();
        try {
            Connection con = DBManager.getInstance().getConnection();
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery(query);
            groups = groupsFromResultSet(rs);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }

    private List<Group> groupsFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Group> groups = new ArrayList<>();
        while(resultSet.next()) {
            groups.add(GroupDAOImpl.fromResultSet(resultSet));
        }
        return groups;
    }

    public static Group fromResultSet(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("ID_group");
        String name = resultSet.getString("name");
        Date date = resultSet.getDate("creationDate");
        User owner = UserDAOImpl.fromResultSet(resultSet);
        Group group = new Group(name, owner);
        group.setCreationDate(date);
        group.setID(ID);
        return group;
    }
}
