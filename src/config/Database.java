package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String HOST = "76.13.88.26";
    private static final String PORT = "3306";
    private static final String DB_NAME = "u674868201_netflix";

    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;

    private static final String USER = "u674868201_lucasjava";
    private static final String PASSWORD = "Lucas30230107";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado no projeto!", e);
        }
    }


}
