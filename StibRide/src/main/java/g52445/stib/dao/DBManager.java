package g52445.stib.dao;

import g52445.stib.config.ConfigManager;
import g52445.stib.repository.RepositoryException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    private Connection connection;

    private DBManager() {
    }

    public Connection getConnection() throws RepositoryException {
        try {
            ConfigManager.getInstance().load();
        } catch (IOException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jdbcUrl = "jdbc:sqlite:" + ConfigManager.getInstance().getProperties("db.url");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl);
            } catch (SQLException ex) {
                throw new RepositoryException("Connexion impossible: " + ex.getMessage());
            }
        }
        return connection;
    }

    public static DBManager getInstance() {
        return DBManagerHolder.INSTANCE;
    }

    private static class DBManagerHolder {

        private static final DBManager INSTANCE = new DBManager();
    }
}
