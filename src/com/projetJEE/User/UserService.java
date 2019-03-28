package com.projetJEE.User;

import java.util.List;

public interface UserService {
    void newUser(User user);
    List<User> getAllUsers();
    User getUserByID(int ID);
    User getUserByLogin(String login);
    void updateUser(User user);
    void deleteUser(User user);
}
