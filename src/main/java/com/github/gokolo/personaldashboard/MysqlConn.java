package com.github.gokolo.personaldashboard;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool.PoolInitializationException;

public final class MysqlConn {
    private static HikariDataSource ds;

    private MysqlConn() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static Connection connect() {
        try {
            if (ds == null) {
                HikariConfig config = new HikariConfig("/hikari.properties");
                ds = new HikariDataSource(config);
            }

            return ds.getConnection();
        } catch (SQLException | PoolInitializationException e) {
            System.err.println("Unable to establish a connection!");
            System.exit(1);
        }
        return null;
    }
}
