package com.projetJEE.User;

import com.projetJEE.DAOImpl;

import java.sql.*;
import java.util.List;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {

    @Override
    public void create(User user) {
        String query = "insert into User (login, pwdHash, question, answerHash, rights) values (?, ?, ?, ?, ?)";
        executeUpdateQuery(query,
                preparedStatement -> { buildUserStatement(user, preparedStatement); },
                generatedKeys -> {
                    if (generatedKeys.next()) {
                        user.setID(generatedKeys.getInt(1));
                        System.out.println("Successfully created " + user);
                    } else {
                        throw new SQLException("No ID generated for " + user);
                    }
                });
    }

    @Override
    public List<User> findAll() {
        String query = "select * from User";
        return getEntriesFromQuery(query, preparedStatement -> {});
    }

    @Override
    public User findByID(int ID) {
        String query = "select * from User where ID_user=?";
        return getUniqueEntryFromQuery(query, preparedStatement -> {
            preparedStatement.setInt(1, ID);
        });
    }

    @Override
    public User findByLogin(String login) {
        String query = "select * from User where login=?";
        return getUniqueEntryFromQuery(query, preparedStatement -> {
            preparedStatement.setString(1, login);
        });
    }

    @Override
    public void update(User user) {
        String query = "update User set " +
                "login=?," +
                "pwdHash=?," +
                "question=?," +
                "answerHash=?," +
                "rights=? " +
                "where ID_user=?";
        executeUpdateQuery(query, preparedStatement -> {
            buildUserStatement(user, preparedStatement);
            preparedStatement.setInt(6, user.getID());
        });
    }

    @Override
    public void delete(User user) {
        String query = "delete from User where ID_user=?";
        executeUpdateQuery(query, preparedStatement -> {
           preparedStatement.setInt(1, user.getID());
        });
    }

    @Override
    public User entryFromResultSet(ResultSet resultSet) throws SQLException {
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

    private void buildUserStatement(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPwdHash());
        preparedStatement.setString(3, user.getQuestion());
        preparedStatement.setString(4, user.getAnswerHash());
        preparedStatement.setString(5, user.getRights().toString());
    }
}
