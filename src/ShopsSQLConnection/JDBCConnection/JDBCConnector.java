package ShopsSQLConnection.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnector {

    private static final String URL = "jdbc:mysql://localhost/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection;

    public static Connection getConnection(){
//        if(connection != null){
//            return connection;
//        }
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return connection;
    }
}
