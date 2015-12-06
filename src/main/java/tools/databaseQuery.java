package tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class databaseQuery {
    private static Connection connection;

    // Get the database connection
    public databaseQuery() {
        connection = databaseConnection.getInstance().getDatabaseConnection();
    }

    public static void dbQuery(String query, Map<String, String> parameters) throws SQLException {
        for (Map.Entry<String, String> element : parameters.entrySet()) {
            query = query.replace(element.getKey(), "'" + element.getValue() + "'");
        }

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setQueryTimeout(15);
        preparedStmt.executeUpdate();
        preparedStmt.close();

    }
}