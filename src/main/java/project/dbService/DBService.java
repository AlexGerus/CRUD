package project.dbService;

import project.dao.DAOFactory;
import project.dao.UserDAO;
import project.module.User;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DBService {
    private UserDAO userDAO;

    public DBService() throws IOException {
        userDAO = DAOFactory.getUserDAO();
    }

    public User findUserById(long id){
        return userDAO.findUserById(id);
    }

    public long saveUser(User user){
        return userDAO.saveUser(user);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void signUpUser(User user){
        userDAO.signUpUser(user);
    }

    public void deleteUser(long id){
        userDAO.deleteUser(id);
    }

    public List<User> findAllUsers(){
        return userDAO.findAllUsers();
    }

    public User getUserByLogin(String login){
        return userDAO.getUserByLogin(login);
    }
}

















