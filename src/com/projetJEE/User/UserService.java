package com.projetJEE.User;

import java.util.List;

public interface UserService {
    boolean newUser(User user);
    List<User> getAllUsers();
    User getUserByID(int ID);
    User getUserByLogin(String login);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
