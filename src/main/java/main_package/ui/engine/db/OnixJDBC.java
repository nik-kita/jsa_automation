package main_package.ui.engine.db;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OnixJDBC {
    private String dbHost;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private Logger logger;

    public OnixJDBC() {
        logger = LoggerFactory.getLogger(this.getClass());
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/credentials.properties"));
        } catch (IOException e) {
            logger.error("It looks like you forgot to create 'src/resources/credentials.properties' file");
        }
        dbHost = properties.getProperty("jsaTestingDbHost");
        dbUser = properties.getProperty("jsaTestingDbUser");
        dbName = properties.getProperty("jsaTestingDbName");
        dbPassword = properties.getProperty("jsaTestingDbPassword");
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbHost, dbUser, dbPassword);
            logger.debug("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }

        return connection;
    }

}
