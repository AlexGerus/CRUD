package project.dao;

import project.dbHelper.Executor;
import project.module.User;
import project.dbHelper.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDAO implements UserDAO{
    private Executor executor;

    public UserJDBCDAO() throws SQLException, ClassNotFoundException {
        this.executor = new Executor(new JDBCConnectionService().getDbConnection());
    }

    public User findUserById(long id) {
        return null;
    }

    public long saveUser(User user) throws SQLException {
        String sql = "insert into users (name, age) values ('" + user.getName() + "', '" + user.getId() + "')";

        executor.execUpdate(sql);
        return user.getId();
    }

    public List<User> findAllUsers() throws SQLException {
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

    @Override
    public User getUserByLogin(String login) throws SQLException {
        return null;
    }

    public void deleteUser(long id) throws SQLException{
        String sql = "delete from users where id = " + id;
        executor.execUpdate(sql);
    }

    public void updateUser(User user) throws SQLException{
        String sql = "update users set name = '" + user.getName() + "', age = " + user.getAge() + " where id = " + user.getId();
        executor.execUpdate(sql);
    }

    @Override
    public void signUpUser(User user) throws SQLException {

    }
}
