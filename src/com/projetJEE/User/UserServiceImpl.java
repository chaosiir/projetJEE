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

    private UserDAO userDAO = new UserDAOImpl();

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

    /**
     * Private constructor since it's a singleton
     */
    private UserServiceImpl() {}

    /**
     * Creates a new user
     * @param user User to create
     * @pre user.getID() == -1
     * @post user.getID() != -1
     * @return The user has been successfully created
     */
    @Override
    public boolean newUser(User user) {
        //hash password and answer
        user.setPwdHash(hash(user.getPwdHash()));
        user.setAnswerHash(hash(user.getAnswerHash()));
        return userDAO.create(user);
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
     * @return The user has been successfully updated
     */
    @Override
    public boolean updateUser(User user) { return userDAO.update(user); }

    /**
     * Deletes a user
     * @param user User to delete
     * @return The user has been successfully deleted
     */
    @Override
    public boolean deleteUser(User user) { return userDAO.delete(user); }

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
