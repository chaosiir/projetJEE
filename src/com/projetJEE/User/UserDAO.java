package com.projetJEE.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    List<User> findAll();
    User findByID(int ID);
    User findByLogin(String login);
    void update(User user);
    void delete(User user);
}
