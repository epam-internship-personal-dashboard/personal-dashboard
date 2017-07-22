package com.github.gokolo.personaldashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SuppressWarnings("PMD")
public final class MysqlConn {
    private static Connection conn;

    private MysqlConn() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static Connection connect() {
        if (conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/personaldashboard?" + "user=root&password=1234");

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
