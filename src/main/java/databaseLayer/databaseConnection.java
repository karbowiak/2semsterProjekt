package databaseLayer;
import config.mhcConfig;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class databaseConnection {
    private static final String driver = mhcConfig.getDriver();
    private static final String databaseName = mhcConfig.getDatabaseName();
    private static final String username = mhcConfig.getUsername();
    private static final String password = mhcConfig.getPassword();
    private static Connection connection;
    private static databaseConnection instance = null;

    public static databaseConnection getInstance() {
        if(instance == null)
            instance = new databaseConnection();

        return instance;
    }

    private databaseConnection() {
        String url = driver + databaseName + username + password;

        // Load the MSSQL JDBC driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("INFO: Loaded driver MSSQL JDBC");
        } catch (Exception e) {
            System.out.println("ERROR: Couldn't load MSSQL JDBC driver");
            System.out.println(e.getMessage());
        }

        // Setup the database connection
        try {
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(true);
            DatabaseMetaData dbMeta = connection.getMetaData();
            System.out.println("INFO: Successfully opened a database connection to: " + dbMeta.getURL());
        } catch (Exception e) {
            System.out.println("ERROR: Couldn't connect to database");
            System.out.println(e.getMessage());
            System.out.println(url);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("INFO: The connection is closed");
        } catch (Exception e) {
            System.out.println("ERROR: Error when trying to close the database connection: " + e.getMessage());
        }
    }

    public Connection getDatabaseConnection() {
        return connection;
    }

    public static void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void commitTransaction() {
        try {
            connection.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void rollbackTransaction() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}