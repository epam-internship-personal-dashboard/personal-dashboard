package com.github.gokolo.personaldashboard;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool.PoolInitializationException;

/**
 * @author Grace_Okolo
 * @version 0.0.1
 * @since
 */
@SuppressWarnings("PMD")
public final class MysqlConn {
    private static final Logger LOG = LoggerFactory.getLogger(MysqlConn.class);
    private static HikariDataSource ds;

    private MysqlConn() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     * @return
     */
    public static Connection connect() {
        LOG.info("Trying to connect to the database");
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
