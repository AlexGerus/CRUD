package project.dbService;

import project.dao.DAOFactory;
import project.dao.UserDAO;
import project.module.User;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DBService {
    private UserDAO userDAO;

    public DBService() throws SQLException, IOException, ClassNotFoundException {
        userDAO = DAOFactory.getUserDAO();
    }

    public User findUserById(long id) throws SQLException, ClassNotFoundException, IOException {
        return userDAO.findUserById(id);
    }

    public long saveUser(User user) throws SQLException, ClassNotFoundException, IOException {
        return userDAO.saveUser(user);
    }

    public void updateUser(User user) throws SQLException, ClassNotFoundException, IOException {
        userDAO.updateUser(user);
    }

    public void signUpUser(User user) throws SQLException, ClassNotFoundException, IOException {
        userDAO.signUpUser(user);
    }

    public void deleteUser(long id) throws SQLException, ClassNotFoundException, IOException {
        userDAO.deleteUser(id);
    }

    public List<User> findAllUsers() throws SQLException, ClassNotFoundException, IOException {
        return userDAO.findAllUsers();
    }

    public User getUserByLogin(String login) throws SQLException {
        return userDAO.getUserByLogin(login);
    }
}

















