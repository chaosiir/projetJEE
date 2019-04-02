package com.projetJEE.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMockImpl implements UserDAO {

    @Override
    public boolean create(User user) { return false; }

    @Override
    public List<User> findAll() { return new ArrayList<>(); }

    @Override
    public User findByID(int ID) {
        return new User("tony", "hash", "question", "hash_answer", User.Rights.USER);
    }

    @Override
    public User findByLogin(String login) {
        return new User(login, "hash", "question", "hash_answer", User.Rights.USER);
    }

    @Override
    public boolean update(User user) { return false; }

    @Override
    public boolean delete(User user) { return false; }
}
