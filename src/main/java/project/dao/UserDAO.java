package project.dao;

import project.dbService.Executor;
import project.module.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Executor executor;

    public UserDAO(Connection connection) {
        this.executor = new Executor(connection);
    }
    public void insertUser(String name, int age) throws SQLException {
        String sql = "insert into users (name, age) values ('" + name + "', '" + age + "')";

        executor.execUpdate(sql);
    }
    public List<User> getUser() throws SQLException {
        return executor.execQuery("select * from users", result -> {
            List<User> list = new ArrayList<>();
            while(result.next()){
                User user = new User(result.getString("name"), result.getInt("age"));
                user.setId(result.getLong("id"));
                list.add(user);
            }
            return list;
        });
    }
    public void deleteUser(long id) throws SQLException{
        String sql = "delete from users where id = " + id;
        executor.execUpdate(sql);
    }
    public void editUser(long id, String name, int age) throws SQLException{
        String sql = "update users set name = '" + name + "', age = " + age + " where id = " + id;
        executor.execUpdate(sql);
    }
}
