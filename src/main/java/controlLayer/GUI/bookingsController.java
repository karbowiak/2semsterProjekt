package controlLayer.GUI;

import modelLayer.Rooms;
import modelLayer.roomBookings;
import tools.QuickHash;
import tools.databaseQuery;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class bookingsController {
    // Load the Guests model
    roomBookings booking = new roomBookings();
    Rooms rooms = new Rooms();

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

    public DefaultComboBoxModel getAllUnrentedRoomsComboBox() {
        ArrayList<LinkedHashMap> allUnrentedRooms = rooms.getAllUnrentedRooms();
        DefaultComboBoxModel roomsList = new DefaultComboBoxModel<String>();

        if(allUnrentedRooms != null) {
            for (LinkedHashMap map : allUnrentedRooms) {
                StringBuilder string = new StringBuilder();
                for(Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if(pair.getKey().equals("roomDescription"))
                        string.append("Description: " + pair.getValue());

                    if(pair.getKey().equals("roomSize"))
                        string.append(" | Size: " + pair.getValue());

                    if(pair.getKey().equals("roomPricePerNight"))
                        string.append(" | Price: " + pair.getValue());
                }
                roomsList.addElement(string);
            }
        }
        return roomsList;
    }

    public ArrayList<LinkedHashMap> getAllUnrentedRoomsHashMap() {
        return rooms.getAllUnrentedRooms();
    }

    // Yes yes, should really be in the model layer, whatever
    public String getBookingID(int roomID, int bookingBureau, String fromDate, String toDate, int employeeID) {
        Map<String, String> parameters = new QuickHash(":roomID", String.valueOf(roomID), ":bookingBureau", String.valueOf(bookingBureau), ":fromDate", String.valueOf(fromDate), ":toDate", String.valueOf(toDate), ":employeeID", String.valueOf(employeeID));
        try {
            return databaseQuery.dbQueryField("SELECT bookingID FROM roomBookings WHERE roomID = :roomID AND bookingBureau = :bookingBureau AND fromDate = :fromDate AND toDate = :toDate AND employeeID = :employeeID", "bookingID", parameters);
        } catch (SQLException e) {
            return "";
        }
    }
    public void createBooking(int roomID, int bookingBureau, String fromDate, String toDate, int employeeID) {
        booking.insertUpdateBooking(0, roomID, bookingBureau, fromDate, toDate, "", "", 0, 0, 0, employeeID, 1);
    }

    public void updateBooking(int bookingID, int roomID, int bookingBureau, String fromDate, String toDate, String checkinDate, String checkoutDate, float priceBeforeDiscount, float discount, float totalPrice, int employeeID, int bookingActive) {
        booking.insertUpdateBooking(bookingID, roomID, bookingBureau, fromDate, toDate, checkinDate, checkoutDate, priceBeforeDiscount, discount, totalPrice, employeeID, bookingActive);
    }

    public void deleteBooking(int bookingID) {
        booking.deleteBooking(bookingID);
    }
}
