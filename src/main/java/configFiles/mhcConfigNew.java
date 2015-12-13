package configFiles;

public class mhcConfigNew {
    public static final String driver = "jdbc:sqlserver://SERVERADDRESS:PORT";
    public static final String databaseName = ";databaseName=DATABASENAME";
    public static final String username = ";user=USERNAME";
    public static final String password = ";password=PASSWORD";

    public static String getDriver() {
        return driver;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
