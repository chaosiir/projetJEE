package com.projetJEE.User;

public class UserDAOMockImpl implements UserDAO {
    @Override
    public User findByID(int ID) {
        return new User(ID, "tony", "hash", "question", "hash_answer");
    }

    @Override
    public User findByLogin(String login) {
        return new User(42, login, "hash", "question", "hash_answer");
    }

    @Override
    public void insert(User user) {
        System.err.println("impossible to insert a new user with the "+UserDAOMockImpl.class.getName());

    }
}
