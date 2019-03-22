package com.projetJEE.User;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public User getUserByID(int ID) {
        return userDAO.findByID(ID);
    }

    @Override
    public void insertUser(User user) {
        userDAO.insert(user);
    }

    @Override
    public void insertUsers(User[] users) {

    }
}
