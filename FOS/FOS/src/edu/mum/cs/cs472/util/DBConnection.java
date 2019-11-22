package edu.mum.cs.cs472.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Connection connection;
    private Properties properties;

    private void readProperties() {
        if (properties == null) {
            properties = new Properties();
            try (InputStream input = getClass().getResourceAsStream("../../../../../../config/common.properties")) {
                properties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Properties getProperties() {

        Properties prop = new Properties();

        if (this.properties == null) {
            readProperties();
        }

        prop.setProperty("user", this.properties.getProperty("db.user"));
        prop.setProperty("password", this.properties.getProperty("db.password"));
        prop.setProperty("MaxPooledStatements", this.properties.getProperty("db.max.pool"));

        return prop;
    }

    public Connection connect() {
        if (connection == null) {
            try {
                if (properties == null) {
                    this.readProperties();
                }
                Class.forName(properties.getProperty("db.driver"));
                connection = DriverManager.getConnection(properties.getProperty("db.url"), getProperties());
            } catch (ClassNotFoundException | SQLException e) {
                // Java 7+
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return this.connect();
    }
}
