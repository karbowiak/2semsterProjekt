package modelLayer;

import tools.databaseQuery;

import java.util.Date;

public class facilityRentals {
    databaseQuery db = new databaseQuery();

    private int rentalID; // an internal ID
    private int facilityID; // The Room ID, references the Rooms table
    private int guestID; // The Guest ID, references the Guest ID
    private Date fromDate; // When it's been booked from (Needs to be a full timestamp, for hour resolution)
    private Date toDate; // When it's been booked to (Needs to be a full timestamp, for hour resolution)
    private Float price; // The price of booking it for the period of time.. Will probably be 0 tho..
}
