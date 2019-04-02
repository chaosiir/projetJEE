package com.projetJEE.User;

import com.projetJEE.DBManager;
import com.projetJEE.Student.StudentServiceImpl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance;

    /**
     * Returns the UserServiceImpl singleton
     * @return UserServiceImpl instance
     */
    public static UserServiceImpl getInstance() {
        if (instance == null) {
            synchronized (UserServiceImpl.class) {
                instance = new UserServiceImpl();
            }
        }
        return instance;
    }

    private UserDAO userDAO = new UserDAOImpl();

    /**
     * Creates a new user
     * @param user User to create
     * @pre user.getID() == -1
     * @post user.getID() != -1
     */
    @Override
    public void newUser(User user) {
        //hash password and answer
        user.setPwdHash(hash(user.getPwdHash()));
        user.setAnswerHash(hash(user.getAnswerHash()));
        userDAO.create(user);
    }

    /**
     * Returns all users
     * @return A list of users
     */
    @Override
    public List<User> getAllUsers() { return userDAO.findAll(); }

    /**
     * Returns a user by ID
     * @param ID User's ID
     * @return The user with that ID or null if nonexistent
     */
    @Override
    public User getUserByID(int ID) {
        return userDAO.findByID(ID);
    }

    /**
     * Returns a user by ID
     * @param login User's login
     * @return The user with that login or null if nonexistent
     */
    @Override
    public User getUserByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    /**
     * Updates a user
     * @param user User to update
     */
    @Override
    public void updateUser(User user) { userDAO.update(user); }

    /**
     * Deletes a user
     * @param user User to delete
     */
    @Override
    public void deleteUser(User user) { userDAO.delete(user); }

    /**
     * Hashes a string with SHA-256 in base 64
     * @param str String to hash
     * @return hashed string
     */
    public String hash(String str){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            String hashStr = Base64.getEncoder().encodeToString(hash);
            return hashStr;
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }
}
