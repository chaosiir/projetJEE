package com.projetJEE.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void newUser(User user) {
        //hash password and answer
        user.setPwdHash(hash(user.getPwdHash()));
        user.setAnswerHash(hash(user.getAnswerHash()));
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
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            String hashStr = Base64.getEncoder().encodeToString(hash);
            System.out.println("hash -> " + hashStr);
            return hashStr;
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }
}
