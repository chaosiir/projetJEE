package com.projetJEE.User;

public interface UserService {
    User getUserByID(int ID);
    User getUserByLogin(String login);
    void newUser(User user);
}
