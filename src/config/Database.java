package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String HOST = "+++++++";
    private static final String PORT = "3306";
    private static final String DB_NAME = "++++++";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

    private static final String USER = "+++++";
    private static final String PASSWORD = "+++++++";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado no projeto!", e);
        }
    }


}
