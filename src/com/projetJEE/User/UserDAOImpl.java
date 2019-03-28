package com.projetJEE.User;

import com.projetJEE.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User findByID(int ID) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = "select * from User where ID_user=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, ID);
            ResultSet rs = preparedStatement.executeQuery();
            User user = usersFromResultSet(rs).get(0);
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByLogin(String login) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = "select * from User where login=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            User user = usersFromResultSet(rs).get(0);
            con.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void create(User user) {
        try {
            Connection con = DBManager.getInstance().getConnection();
            String query = "insert into User (login, pwdHash, question, answerHash, rights) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPwdHash());
            preparedStatement.setString(3, user.getQuestion());
            preparedStatement.setString(4, user.getAnswerHash());
            preparedStatement.setString(5, user.getRights().toString());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setID(generatedKeys.getInt(1));
                System.out.println("Successfully created user " + user);
            } else {
                throw new SQLException("NO ID GENERATED FOR USER");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<User> usersFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        while(resultSet.next()) {
            users.add(UserDAOImpl.fromResultSet(resultSet));
        }
        return users;
    }

    public static User fromResultSet(ResultSet resultSet) throws SQLException {
        int ID = resultSet.getInt("ID_user");
        String login = resultSet.getString("login");
        String pwdHash = resultSet.getString("pwdHash");
        String question = resultSet.getString("question");
        String answerHash = resultSet.getString("answerHash");
        User.Rights rights = User.Rights.valueOf(resultSet.getString("rights"));
        User user = new User(login, pwdHash, question, answerHash, rights);
        user.setID(ID);
        return user;
    }
}
