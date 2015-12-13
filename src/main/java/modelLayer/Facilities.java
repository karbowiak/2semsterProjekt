package modelLayer;
import tools.QuickHash;
import tools.StringTools;
import tools.databaseQuery;

import java.sql.SQLException;
import java.util.*;

import static tools.databaseQuery.dbQuery;
import static tools.databaseQuery.dbQueryRow;
import static tools.databaseQuery.dbQueryField;
import static tools.databaseQuery.dbExecute;

public class Facilities {
    databaseQuery db = new databaseQuery();

    private int facilityID; // Internal ID in the db, of no real consequence
    private String facilityType; // The type of the facility
    private String facilityDescription; // The facility description
    private int status; // 0 free, 1 taken
    private float pricePerHour; // The price for booking this facility per hour, should probably be 0 tho

    public ArrayList<LinkedHashMap> getAllFacilities() {
        Map<String,String> parameters = new QuickHash();
        try {
            return dbQuery("SELECT * FROM facilities", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    public LinkedHashMap getAllFacilityRowsByID(int facilityID) throws SQLException {
        Map<String, String> parameters = new QuickHash(":facilityID", String.valueOf(facilityID));
        try {
            return dbQueryRow("SELECT * FROM facilities WHERE facilityID = :facilityID", parameters);
        } catch(Exception e) {
            return null;
        }
    }

}
