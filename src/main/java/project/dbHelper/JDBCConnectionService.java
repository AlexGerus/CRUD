package project.dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionService {
    private Connection connection;

    public JDBCConnectionService() throws SQLException, ClassNotFoundException {
        connection = getDbConnection();
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "db_crub" + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionString, "root", "admin");
        return connection;
    }
}
