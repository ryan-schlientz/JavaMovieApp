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
            try {
                String url = System.getenv("db_url");
                String username = System.getenv("db_user");
                String password = System.getenv("db_pass");

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
