package com.projetJEE.User;

public class UserDAOMockImpl implements UserDAO {
    @Override
    public User findByID(int ID) {
        return new User("tony", "hash", "question", "hash_answer", User.Rights.USER);
    }

    @Override
    public User findByLogin(String login) {
        return new User(login, "hash", "question", "hash_answer", User.Rights.USER);
    }

    @Override
    public void create(User user) { }
}
