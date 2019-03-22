package com.projetJEE.User;

public interface UserDAO {
    User findByID(int ID);
    User findByLogin(String login);
    void insert(User user);
}
