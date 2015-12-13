package modelLayer;

import tools.QuickHash;
import tools.databaseQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// Static import the dbQuery tools
import static tools.databaseQuery.dbQuery;
import static tools.databaseQuery.dbQueryRow;
import static tools.databaseQuery.dbQueryField;
import static tools.databaseQuery.dbExecute;

public class Rooms {
    // Not really used for anything, just reminders what fields are in the database
    private int roomID; // the room ID
    private String roomDescription; // the room description
    private int roomSize; // Type of room, 1 for 1 person room, 2 for 2 person room, 3 for 3 person room etc.
    private int roomStatus; // 0 free, 1 taken
    private float roomDiscount; // the discount applied to this room by default (if it's a haunted room for example)
    private float roomPricePerNight; // the price of the room pr. night

    // Get all data for all rooms
    public ArrayList<LinkedHashMap> getAllRooms() {
        Map<String, String> parameters = new QuickHash();
        try {
            return dbQuery("SELECT * FROM rooms", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // Get all data for a single room by roomID
    public LinkedHashMap getRoomByRoomID(int roomID) {
        Map<String, String> parameters = new QuickHash(":roomID", String.valueOf(roomID));
        try {
            return dbQueryRow("SELECT * FROM rooms WHERE roomID = :roomID", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // Get all rooms by size..
    public ArrayList<LinkedHashMap> getRoomByRoomSize(int roomSize) {
        Map<String, String> parameters = new QuickHash(":roomSize", String.valueOf(roomSize));
        try {
            return dbQuery("SELECT * FROM rooms WHERE roomSize = :roomSize", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<LinkedHashMap> getRoomByRoomStatus(int roomStatus) {
        Map<String, String> parameters = new QuickHash(":roomStatus", String.valueOf(roomStatus));
        try {
            return dbQuery("SELECT * FROM rooms WHERE roomStatus = :roomStatus", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<LinkedHashMap> getRoomByRoomPricePerNight(float roomPricePerNight) {
        Map<String, String> parameters = new QuickHash(":roomPricePerNight", String.valueOf(roomPricePerNight));
        try {
            return dbQuery("SELECT * FROM rooms WHERE roomPricePerNight = :roomPricePerNight", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // fucking overload it, i want default variables, damnit i'm getting them !
    // Also seriously java, no default variables in functions? stop being such a shitty language, plz..
    public int insertUpdateRoom() {
        return insertUpdateRoom("", 0, 0, 0, 0);
    }

    public int insertUpdateRoom(String roomDescription, int roomSize, int roomStatus, float roomDiscount, float roomPricePerNight) {
        // check if it exists, if it doesn't update it.. also fuck microsoft sql server so hard.
        // MySQL: INSERT INTO table () VALUES () ON DUPLICATE KEY UPDATE key = value ....
        // MSSQL: http://i.imgur.com/zT1VT4L.png <- that.. tha... wow..
        // Also: http://i.imgur.com/NiyJuVg.png - seriously, upgrade your shitty mssql server you useless assholes.
        // Fucking mickey mouse education.
        // Ps. MSSQL is the ISIS of the database server world.

        int id;
        // Get ID
        Map<String, String> parameters = new QuickHash(":roomDescription", String.valueOf(roomDescription), ":roomSize", String.valueOf(roomSize), ":roomStatus", String.valueOf(roomStatus), ":roomDiscount", String.valueOf(roomDiscount), ":roomPricePerNight", String.valueOf(roomPricePerNight));
        try {
            id = Integer.parseInt(dbQueryField("SELECT roomID FROM rooms WHERE roomDescription = :roomDescription AND roomSize = :roomSize AND roomStatus = :roomStatus AND roomDiscount = :roomDiscount AND roomPricePerNight = :roomPricePerNight", "roomID", parameters));
        } catch (SQLException e) {
            id = 0;
        }

        // If id is larger than 0 then we update, else we insert
        if(id > 0) {
            Map<String, String> updateParameters = new QuickHash(":roomID", String.valueOf(id), ":roomDescription", String.valueOf(roomDescription), ":roomSize", String.valueOf(roomSize), ":roomStatus", String.valueOf(roomStatus), ":roomDiscount", String.valueOf(roomDiscount), ":roomPricePerNight", String.valueOf(roomPricePerNight));
            try {
                // Update the fields that are set!
                if(roomDescription != "")
                    dbExecute("UPDATE rooms SET roomDescription = :roomDescription WHERE roomID = :roomID", updateParameters);
                if(roomSize > 0)
                    dbExecute("UPDATE rooms SET roomSize = :roomSize WHERE roomID = :roomID", updateParameters);
                if(roomStatus > 0)
                    dbExecute("UPDATE rooms SET roomStatus = :roomStatus WHERE roomID = :roomID", updateParameters);
                if(roomDiscount > 0)
                    dbExecute("UPDATE rooms SET roomDiscount = :roomDiscount WHERE roomID = :roomID", updateParameters);
                if(roomPricePerNight > 0)
                    dbExecute("UPDATE rooms SET roomPricePerNight = :roomPricePerNight WHERE roomID = :roomID", updateParameters);
            } catch (SQLException e) {
                return 0;
            }
        }
        else {
            // Insert
            try {
                dbExecute("INSERT INTO rooms (roomDescription, roomSize, roomStatus, roomDiscount, roomPricePerNight) VALUES (:roomDescription, :roomSize, :roomStatus, :roomDiscount, :roomPricePerNight)", parameters);
            } catch (SQLException e) {
                return 0;
            }
        }

        // It was inserted / updated.. lets assume so
        return id;
    }

    //databaseQuery dbQ = new databaseQuery();
    //Map<String,String> parameters = new QuickHash(":name", "1", ":value", "palle");
    //dbQ.dbQuery("INSERT INTO test (name, value) VALUES (:name, :value)", parameters);
}
