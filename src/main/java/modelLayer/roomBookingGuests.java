package modelLayer;
import tools.QuickHash;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static tools.databaseQuery.dbExecute;
import static tools.databaseQuery.dbQuery;

public class roomBookingGuests {
    private int bookingID; // The id of the booking
    private int guestID; // The id of the guest that is attached to the bookingID

    // Get all the guests attached to a bookingID
    public ArrayList<LinkedHashMap> getAllGuestsByBookingID(int bookingID) {
        Map<String, String> parameters = new QuickHash(":bookingID", String.valueOf(bookingID));
        try {
            return dbQuery("SELECT guestID FROM bookingGuests WHERE bookingID = :bookingID", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // Insert a guest to a bookingID
    public boolean insertRoomGuestBooking(int bookingID, int guestID) {
        int id;
        Map<String, String> parameters = new QuickHash(":bookingID", String.valueOf(bookingID), ":guestID", String.valueOf(guestID));
        try {
            dbExecute("INSERT INTO bookingGuests (bookingID, guestID) VALUES (:bookingID, :guestID)", parameters);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean deleteGuestFromBooking(int bookingID, int guestID) {
        Map<String, String> parameters = new QuickHash(":bookingID", String.valueOf(bookingID), ":guestID", String.valueOf(guestID));
        try {
            dbExecute("DELETE FROM bookingGuests WHERE bookingID = :bookingID AND guestID = :guestID", parameters);
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
