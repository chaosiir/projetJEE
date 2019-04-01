package com.projetJEE.User;

import com.projetJEE.DBManager;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                instance = new UserServiceImpl();
            }
        }
        return instance;
    }

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void newUser(User user) {
        // TODO : hash user password and answer
        userDAO.create(user);
    }

    @Override
    public List<User> getAllUsers() { return userDAO.findAll(); }

    @Override
    public User getUserByID(int ID) {
        return userDAO.findByID(ID);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Override
    public void updateUser(User user) { userDAO.update(user); }

    @Override
    public void deleteUser(User user) { userDAO.delete(user); }

    public String hash(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest("password".getBytes(StandardCharsets.UTF_8));
            return new String(hash, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }
}
