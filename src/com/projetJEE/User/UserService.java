package com.projetJEE.User;

public interface UserService {
    User getUserByID(int ID);
    void insertUser(User user);
    void insertUsers(User[] users);
}
