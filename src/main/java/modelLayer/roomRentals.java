package modelLayer;
import tools.databaseQuery;
import java.util.Date;

public class roomRentals {
    databaseQuery db = new databaseQuery();

    private int rentalID; // an internal ID
    private int roomID; // The Room ID, references the Rooms table
    private int guestID; // The Guest ID, references the Guest ID
    private int bookingBureau; // The booking Bureaus ID, references the booking Bureau Table (not really used, just exists)
    private Date fromDate; // When it's been rented from
    private Date toDate; // When it's been rented to
    private float priceBeforeDiscount; // The price before discount was applied
    private float discount; // The discount in percent
    private float totalPrice; // The total price after discount has been added
    private int status; // 1: Booked and paid, 2: checked in, 3: checked out

}
