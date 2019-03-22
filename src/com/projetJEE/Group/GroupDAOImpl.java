package com.projetJEE.Group;

import com.projetJEE.DBManager;
import com.projetJEE.Student.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroupDAOImpl implements GroupDAO {

    @Override
    public List<Group> findAll() {
        return groupsFromQuery("select * from Group");
    }

    @Override
    public Group findByID(int ID_group) {
        List<Group> groups = groupsFromQuery("select * from Group where ID_group=" + ID_group);
        return groups.isEmpty() ? null : groups.get(0);
    }

    @Override
    public Group findByName(String name) {
        List<Group> groups = groupsFromQuery("select * from Group where name=" + name);
        return groups.isEmpty() ? null : groups.get(0);
    }

    @Override
    public void createGroup(String name) {

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
            int ID_group = resultSet.getInt("ID_group");
            String name = resultSet.getString("name");

            groups.add(new Group(ID_group, name));
        }
        return groups;
    }
}
