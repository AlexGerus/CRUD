package project.dao;

import project.module.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    User findUserById(long id);
    long saveUser(User user);
    void updateUser(User user);
    void signUpUser(User user);
    void deleteUser(long id);
    List<User> findAllUsers();
    User getUserByLogin(String login);

}
