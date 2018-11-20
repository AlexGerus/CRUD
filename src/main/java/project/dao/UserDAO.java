package project.dao;

import project.module.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User findUserById(long id);
    long saveUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(long id) throws SQLException;
    List<User> findAllUsers() throws SQLException;
}
