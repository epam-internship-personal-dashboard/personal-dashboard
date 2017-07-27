package com.github.gokolo.personaldashboard.data;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool.PoolInitializationException;

/**
 * This convenience class encapsulates a single {@link javax.sql.DataSource}
 * instance and provides a public method for clients to get an instance of
 * {@link Connection} to a particular database.
 *
 * Connection details are externalized into a configuration file.
 *
 * The class uses HikariCP as a datasource abstraction layer.
 *
 * @author  Grace_Okolo, Attila_Gyongyosi
 * @since   0.0.1
 * @see     com.github.gokolo.personaldashboard.data.dao.AddressDAOImpl
 * @see     com.github.gokolo.personaldashboard.data.dao.UserDAOImpl
 */
public final class ConnectionProvider {
    private static final Logger LOG = LoggerFactory.getLogger(ConnectionProvider.class);

    private static HikariDataSource dataSource;

    private ConnectionProvider() {}

    /**
     * Provides a {@link Connection} instance from the underlying {@link HikariDataSource}.
     * Will create the datasource if it doesn't exist yet.
     *
     * The method will stop the application if it can't establish connection.
     *
     * @return  A {@link Connection} object representing an open connection to a database.
     *
     * @since   0.0.1
     */
    public static synchronized Connection connect() {
        LOG.info("Retrieving database connection...");

        try {
            if (dataSource == null) {
                LOG.debug("Datasource doesn't exist yet, creating new...");
                HikariConfig config = new HikariConfig("/hikari.properties");
                dataSource = new HikariDataSource(config);
            }

            Connection conn = dataSource.getConnection();
            LOG.info("Connection established to the database.");
            return conn;
        } catch (SQLException | PoolInitializationException e) {
            LOG.error("An error occurred while connecting to the database! Exiting.", e);
            System.exit(1);
        }

        return null;
    }
}
