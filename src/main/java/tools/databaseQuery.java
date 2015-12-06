package tools;

import java.sql.*;
import java.util.*;

public class databaseQuery {
    private static Connection connection;

    // Get the database connection
    public databaseQuery() {
        connection = databaseConnection.getInstance().getDatabaseConnection();
    }

    // Only to be used with insert / update since it returns nothing
    public static void dbExecute(String query, Map<String, String> parameters) throws SQLException {
        for (Map.Entry<String, String> element : parameters.entrySet()) {
            query = query.replace(element.getKey(), "'" + element.getValue() + "'");
        }

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setQueryTimeout(15);
        preparedStmt.executeUpdate();
        preparedStmt.close();
    }

    // Returns all rows
    public static ArrayList dbQuery(String query, Map<String, String> parameters) throws SQLException {
        for (Map.Entry<String, String> element : parameters.entrySet()) {
            query = query.replace(element.getKey(), "'" + element.getValue() + "'");
        }

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setQueryTimeout(15);
        ResultSet results = preparedStmt.executeQuery();

        return getMaps(results);
    }

    // Returns one row
    public static LinkedHashMap<String, Object> dbQueryRow(String query, Map<String, String> parameters) throws SQLException {
        for (Map.Entry<String, String> element : parameters.entrySet()) {
            query = query.replace(element.getKey(), "'" + element.getValue() + "'");
        }

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setQueryTimeout(15);
        ResultSet results = preparedStmt.executeQuery();

        return getMap(results);
    }

    // Returns the field
    public static String dbQueryField(String query, String Field, Map<String, String> parameters) throws SQLException {
        for (Map.Entry<String, String> element : parameters.entrySet()) {
            query = query.replace(element.getKey(), "'" + element.getValue() + "'");
        }

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setQueryTimeout(15);
        ResultSet results = preparedStmt.executeQuery();

        Map<String, Object> resultMap = getMap(results);

        for (Object o : resultMap.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            if (pair.getKey().toString().equals(Field))
                return pair.getValue().toString();
        }

        return "";
    }

    // Generates a collection of HashMaps with data inside to iterate over.
    private static ArrayList getMaps(ResultSet resultSet) throws SQLException {

        // Acquire resultSet MetaData
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols = metaData.getColumnCount();

        // Use ArrayList to maintain ResultSet sequence
        ArrayList list = new ArrayList();

        // Scroll to each record, make map of row, add to list
        while (resultSet.next()) {
            LinkedHashMap row = new LinkedHashMap(cols, 1);
            for (int i=1; i<=cols ; i++) {
                //noinspection unchecked
                row.put(metaData.getColumnName(i),
                        resultSet.getString(i));
            }
            //noinspection unchecked
            list.add(row);
        } // end while

        return list;

    }

    // Generates a Map with data..
    private static LinkedHashMap<String, Object> getMap(ResultSet resultSet) throws SQLException {
        // Acquire resultSet MetaData
        ResultSetMetaData metaData = resultSet.getMetaData();
        int cols = metaData.getColumnCount();

        // Create hashmap, sized to number of columns
        LinkedHashMap row = new LinkedHashMap<String, Object>(cols, 1);

        // Transfer record into hashmap
        if (resultSet.next()) {
            for (int i = 1; i <= cols; i++) {
                row.put(metaData.getColumnName(i),
                        resultSet.getObject(i));
            }
        } // end while

        return (row);
    }
}