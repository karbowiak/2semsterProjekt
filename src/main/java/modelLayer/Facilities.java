package modelLayer;
import tools.databaseQuery;

public class Facilities {
    databaseQuery db = new databaseQuery();

    private int facilityID; // Internal ID in the db, of no real consequence
    private String facilityType; // The type of the facility
    private String facilityDescription; // The facility description
    private int amount; // Amount of this type of facility there actually is
    private int status; // 0 free, 1 taken
    private float pricePerHour; // The price for booking this facility per hour, should probably be 0 tho

    //databaseQuery dbQ = new databaseQuery();
    //Map<String,String> parameters = new QuickHash(":name", "1", ":value", "palle");
    //dbQ.dbQuery("INSERT INTO test (name, value) VALUES (:name, :value)", parameters);
}
