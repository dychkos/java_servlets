package com.unrgo.javaee_1.services;

import com.unrgo.javaee_1.helpers.Produces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static class JDBCConnectionProducer {
        @Produces
        private Connection createConnection() {
            Connection conn = null;
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                conn = DriverManager.getConnection("jdbc:derby:memory:chapter02DB",
                        "APP", "APP");
            } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
                throwables.printStackTrace();
            }
            return conn;
        }
        private void closeConnection(@Disposes Connection conn) throws SQLException
        {
            conn.close();
        }
    }
}
