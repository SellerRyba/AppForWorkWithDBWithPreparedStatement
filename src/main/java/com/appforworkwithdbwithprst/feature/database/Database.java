package com.appforworkwithdbwithprst.feature.database;

import com.appforworkwithdbwithprst.feature.prefs.Prefs;

import java.sql.*;

public class Database {
    private static final Database INSTANCE = new Database();
    private final Connection connection;

    private Database() {
        String connectionUrl = new Prefs().getString(Prefs.JDBC_CONNECTION_URL);
        try {
            connection = DriverManager.getConnection(connectionUrl, "postgres", "147852");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String sql) {
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            return st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

