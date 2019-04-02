package com.projetJEE.User;

import java.util.List;

public interface UserDAO {
    boolean create(User user);
    List<User> findAll();
    User findByID(int ID);
    User findByLogin(String login);
    boolean update(User user);
    boolean delete(User user);
}
