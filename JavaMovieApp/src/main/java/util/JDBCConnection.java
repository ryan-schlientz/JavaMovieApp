package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        /*
        To establish a connection we need 3 credentials:
        url (endpoint), username, password
         */

        if (conn == null) {
//            String endpoint = "ryan2104postgres.cpbskq7nq5ve.us-east-1.rds.amazonaws.com";
//            //URL Format: jdbc:postgresql://[host]/[database]
//            String url = "jdbc:postgresql://" + endpoint + "/postgres";
//            String username = "ryan";
//            String password = "password";

            try {
//                FileInputStream input = new FileInputStream("src/main/resources/connection.properties");
                FileInputStream input = new FileInputStream(JDBCConnection.class.getClassLoader().getResource("connection.properties").getFile());

                Properties props = new Properties();
                props.load(input);

                String url = props.getProperty("url");
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return conn;

    }

    /*
    This is for testing purposes only. Not needed to actually use JDBC.
     */
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();
        Connection conn3 = getConnection();
        System.out.println(conn1);
        System.out.println(conn2);
        System.out.println(conn3);

    }

}