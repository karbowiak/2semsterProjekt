package modelLayer;

import tools.QuickHash;
import tools.databaseQuery;

import java.sql.SQLException;
import java.util.*;

import static tools.databaseQuery.dbQuery;
import static tools.databaseQuery.dbQueryRow;
import static tools.databaseQuery.dbQueryField;
import static tools.databaseQuery.dbExecute;
public class Employee {
    databaseQuery db = new databaseQuery();

    public ArrayList<LinkedHashMap> getAllEmployees() {
        Map<String, String> parameters = new QuickHash();
        try {
            return dbQuery("SELECT * FROM persons WHERE personType = 2", parameters);
        } catch (SQLException e) {
            return null;
        }
    }
}
