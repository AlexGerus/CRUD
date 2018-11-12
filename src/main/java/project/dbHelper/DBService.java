package project.dbHelper;

import project.dao.UserDAO;
import project.module.User;

import java.sql.*;
import java.util.List;

public class DBService {
    private Connection connection;

    public DBService() throws SQLException, ClassNotFoundException {
        connection = getDbConnection();
    }

    public void addUser(User user) throws SQLException{

            connection.setAutoCommit(false);
            UserDAO dao = new UserDAO(connection);
            dao.insertUser(user.getName(), user.getAge());
            connection.commit();


    }

    public List<User> getUser() throws SQLException{
            UserDAO dao = new UserDAO(connection);
            return dao.getUser();

    }

    public void deleteUser(long id) throws SQLException{
        connection.setAutoCommit(false);
        UserDAO dao = new UserDAO(connection);
        dao.deleteUser(id);
        connection.commit();
    }

    public void editUser(long id, String name, int age) throws SQLException{
        connection.setAutoCommit(false);
        UserDAO dao = new UserDAO(connection);
        dao.editUser(id, name, age);
        connection.commit();
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
    String connectionString = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "db_crub" + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(connectionString, "root", "admin");

         return connection;
}
    }


