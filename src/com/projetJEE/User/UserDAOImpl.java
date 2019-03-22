package com.projetJEE.User;

import com.projetJEE.DBManager;
import com.projetJEE.Student.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findByID(int ID) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = "select * into User where ID_user=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            con.close();
            return usersFromResultSet(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = "select * into User where login=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            con.close();
            return usersFromResultSet(rs).get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = " insert into User values (?, ?, ?, ?,)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPwdHash());
            preparedStatement.setString(3, user.getQuestion());
            preparedStatement.setString(4, user.getAnswerHash());


            preparedStatement.execute();
            System.out.println("Successfully inserted " + user);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(Student student) throws SQLException {
    }

    private List<User> usersFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<User> users = new ArrayList<>();

        while(resultSet.next()) {
            int ID = resultSet.getInt("ID_user");
            String login = resultSet.getString("login");
            String pwdHash = resultSet.getString("pwdHash");
            String question = resultSet.getString("question");
            String answerHash = resultSet.getString("answerHash");

            users.add(new User(ID, login, pwdHash, question, answerHash));
        }
        return users;
    }
}
