package modelLayer;
import tools.QuickHash;

import java.sql.SQLException;
import java.util.*;
import static tools.databaseQuery.dbQuery;
import static tools.databaseQuery.dbQueryRow;
import static tools.databaseQuery.dbQueryField;
import static tools.databaseQuery.dbExecute;

public class roomBookings {
    private int bookingID; // an internal ID
    private int roomID; // The Room ID, references the Rooms table
    private int bookingBureau; // The booking Bureaus ID, references the booking Bureau Table (not really used, just exists)
    private Date fromDate; // When it's been rented from
    private Date toDate; // When it's been rented to
    private Date checkinDate;
    private Date checkoutDate;
    private float priceBeforeDiscount; // The price before discount was applied
    private float discount; // The discount in percent
    private float totalPrice; // The total price after discount has been added
    private int employeeID; // the personID of the person who setup this booking
    private int bookingActive;

    // Default to 1 for the booking Active
    public ArrayList<LinkedHashMap> getAllBookings() {
        return getAllBookings(1);
    }

    public ArrayList<LinkedHashMap> getAllBookings(int bookingActive) {
        Map<String, String> parameters = new QuickHash(":bookingActive", String.valueOf(bookingActive));
        try {
            return dbQuery("SELECT * FROM roomBookings WHERE bookingActive = :bookingActive", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // Default to 1 for the booking Active
    public LinkedHashMap getBookingByID(int bookingID) {
        return getBookingByID(bookingID, 1);
    }

    public LinkedHashMap getBookingByID(int bookingID, int bookingActive) {
        Map<String, String> parameters = new QuickHash(":bookingID", String.valueOf(bookingID), ":bookingActive", String.valueOf(bookingActive));
        try {
            return dbQueryRow("SELECT * FROM roomBookings WHERE bookingID = :bookingID AND bookingActive = :bookingActive", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    // Default to 1 for the booking Active
    public int insertUpdateBooking() {
        return insertUpdateBooking(0, 0, 0, "", "", "", "", 0, 0, 0, 0, 1);
    }
    public int insertUpdateBooking(int bookingID, int roomID, int bookingBureau, String fromDate, String toDate, String checkinDate, String checkoutDate, float priceBeforeDiscount, float discount, float totalPrice, int employeeID, int bookingActive) {
        int id;
        Map<String, String> parameters = new QuickHash(":roomID", String.valueOf(roomID), ":bookingBureau", String.valueOf(bookingBureau), ":fromDate", String.valueOf(fromDate), ":toDate", String.valueOf(toDate), ":checkinDate", String.valueOf(checkinDate), ":checkoutDate", String.valueOf(checkoutDate), ":priceBeforeDiscount", String.valueOf(priceBeforeDiscount), ":discount", String.valueOf(discount), ":totalPrice", String.valueOf(totalPrice), ":employeeID", String.valueOf(employeeID));

        if(bookingID > 0) {
            id = bookingID;
        }
        else {
            try {
                String queryData = dbQueryField("SELECT bookingID FROM roomBookings WHERE roomID = :roomID AND fromDate = :fromDate AND toDate = :toDate AND bookingActive = 1", "bookingID", parameters);
                if(!Objects.equals(queryData, ""))
                    id = Integer.parseInt(queryData);
                else
                    id = 0;
            } catch (SQLException e) {
                id = 0;
            }
        }
        // If id is larger than 0 then we update, else we insert
        if(id > 0) {
            Map<String, String> updateParameters = new QuickHash(
                    ":bookingID", String.valueOf(id),
                    ":roomID", String.valueOf(roomID),
                    ":bookingBureau", String.valueOf(bookingBureau),
                    ":fromDate", String.valueOf(fromDate),
                    ":toDate", String.valueOf(toDate),
                    ":checkinDate", String.valueOf(checkinDate),
                    ":checkoutDate", String.valueOf(checkoutDate),
                    ":priceBeforeDiscount", String.valueOf(priceBeforeDiscount),
                    ":discount", String.valueOf(discount),
                    ":totalPrice", String.valueOf(totalPrice),
                    ":employeeID", String.valueOf(employeeID),
                    ":bookingActive", String.valueOf(bookingActive)
            );
            try {
                // Update the fields that are set!
                if(roomID > 0)
                    dbExecute("UPDATE roomBookings SET roomID = :roomID WHERE bookingID = :bookingID", updateParameters);
                if(bookingBureau > 0)
                    dbExecute("UPDATE roomBookings SET bookingBureau = :bookingBureau WHERE bookingID = :bookingID", updateParameters);
                if(!Objects.equals(fromDate, ""))
                    dbExecute("UPDATE roomBookings SET fromDate = :fromDate WHERE bookingID = :bookingID", updateParameters);
                if(!Objects.equals(toDate, ""))
                    dbExecute("UPDATE roomBookings SET toDate = :toDate WHERE bookingID = :bookingID", updateParameters);
                if(!Objects.equals(checkinDate, ""))
                    dbExecute("UPDATE roomBookings SET checkinDate = :checkinDate WHERE bookingID = :bookingID", updateParameters);
                if(!Objects.equals(checkoutDate, ""))
                    dbExecute("UPDATE roomBookings SET checkoutDate = :checkoutDate WHERE bookingID = :bookingID", updateParameters);
                if(priceBeforeDiscount > 0)
                    dbExecute("UPDATE roomBookings SET priceBeforeDiscount = :priceBeforeDiscount WHERE bookingID = :bookingID", updateParameters);
                if(discount > 0)
                    dbExecute("UPDATE roomBookings SET discount = :discount WHERE bookingID = :bookingID", updateParameters);
                if(totalPrice > 0)
                    dbExecute("UPDATE roomBookings SET totalPrice = :totalPrice WHERE bookingID = :bookingID", updateParameters);
                if(employeeID > 0)
                    dbExecute("UPDATE roomBookings SET employeeID = :employeeID WHERE bookingID = :bookingID", updateParameters);
                if(bookingActive < 1)
                    dbExecute("UPDATE roomBookings SET bookingActive = :bookingActive WHERE bookingID = :bookingID", updateParameters);
            } catch (SQLException e) {
                return 0;
            }
        }
        else {
            // Insert
            try {
                dbExecute("INSERT INTO roomBookings (roomID, bookingBureau, fromDate, toDate, priceBeforeDiscount, discount, totalPrice, employeeID) VALUES (:roomID, :bookingBureau, :fromDate, :toDate, :priceBeforeDiscount, :discount, :totalPrice, :employeeID)", parameters);
            } catch (SQLException e) {
                return 0;
            }
        }

        // It was inserted / updated.. lets assume so
        return id;
    }

    public boolean deleteBooking(int bookingID) {
        // set bookingActive to 0
        Map<String, String> parameters = new QuickHash(":bookingID", String.valueOf(bookingID));
        try {
            dbExecute("UPDATE roomBookings SET bookingActive = 0 WHERE bookingID = :bookingID", parameters);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
