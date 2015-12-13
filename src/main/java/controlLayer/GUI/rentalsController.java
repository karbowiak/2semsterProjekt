package controlLayer.GUI;

import modelLayer.roomBookings;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class rentalsController {
    // Load the Guests model
    roomBookings booking = new roomBookings();

    public DefaultListModel getAllRoomBookingsListModel() {
        ArrayList<LinkedHashMap> allBookings = booking.getAllBookings();
        DefaultListModel bookingsList = new DefaultListModel<String>();

        if(allBookings != null) {
            for (LinkedHashMap map : allBookings) {
                StringBuilder string = new StringBuilder();
                for (Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if (pair.getKey().equals("bookingBureau"))
                        string.append(pair.getValue() + " | ");

                    if (pair.getKey().equals("roomID"))
                        string.append(pair.getValue() + " | ");

                    if (pair.getKey().equals("fromDate"))
                        string.append(pair.getValue());
                }
                bookingsList.addElement(string);
            }
        }
        return bookingsList;
    }

    public ArrayList<LinkedHashMap> getAllBookingsHashMap() {
        return booking.getAllBookings();
    }

    public void createBooking() {
        booking.insertUpdateBooking();
    }

    public void updateBooking() {
        booking.insertUpdateBooking();
    }

    public void deleteBooking(int bookingID) {
        booking.deleteBooking(bookingID);
    }
}
