package com.projetJEE.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User getUserByID(int ID) {
        return userDAO.findByID(ID);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public void newUser(User user) {
        // TODO : hash user password and answer
        userDAO.create(user);
    }

    public String hash(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest("password".getBytes(StandardCharsets.UTF_8));
            return new String(hash, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }
}
