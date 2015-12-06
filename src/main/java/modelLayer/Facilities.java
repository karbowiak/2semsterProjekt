package modelLayer;
import tools.QuickHash;
import tools.databaseQuery;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
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

    public Collection getAllFacilities() {
        Map<String,String> parameters = new QuickHash();
        try {
            return dbQuery("SELECT * FROM facilities", parameters);
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public void getAllFacilitiesByFacilityType() throws SQLException {

    }

    public void getAllFacilitiesByStatus() throws SQLException {

    }

    public void getFacilityTypeByID() throws SQLException {

    }

    public void getFacilityDescriptionByID() throws SQLException {

    }

    public void getFacilityStatusByID() throws SQLException {

    }

    public void getFacilityPricePerHourByID() throws SQLException {

    }

    public boolean setFacilityTypeByID() throws SQLException {
        return false;
    }

    public boolean setFacilityDescriptionByID() throws SQLException {
        return false;
    }

    public boolean setFacilityStatusByID() throws SQLException {
        return false;
    }

    public boolean setFacilityPricePerHourByID() throws SQLException {
        return false;
    }

    public boolean insertFacility(String facilityType, String facilityDescription, int status, float pricePerHour) throws SQLException {
        return false;
    }
}
