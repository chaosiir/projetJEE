package com.projetJEE.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOMockImpl implements UserDAO {

    @Override
    public void create(User user) { }

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
    public void update(User user) { }

    @Override
    public void delete(User user) { }
}
