package com.github.gokolo.personaldashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConn {
    private static Connection conn;
    private static Statement st = null;
    private static ResultSet rs = null;

    String url = "jdbc:mysql://localhost:3306/personaldashboard";
    String user = "root";
    String password = "1234";

    public static Connection connect() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/personaldashboard"
                        + "?verifyServerCertificate=true" + "&useSSL=true" + "&requireSSL=true");

            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return conn;
    }
}
