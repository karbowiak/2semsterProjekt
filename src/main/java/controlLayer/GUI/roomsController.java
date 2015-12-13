package controlLayer.GUI;

import modelLayer.Rooms;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// Return all facilities as a DefaultListModel
public class roomsController {
    // Load the Rooms model
    Rooms rooms = new Rooms();

    // List all rooms
    // Get information on one room
    // Create room
    // Edit room
    // Delete room

    public DefaultListModel getAllRoomsListModel() {
        ArrayList<LinkedHashMap> allRooms = rooms.getAllRooms();
        DefaultListModel roomsList = new DefaultListModel<String>();

        if(allRooms != null) {
            for (LinkedHashMap map : allRooms) {
                StringBuilder string = new StringBuilder();
                for (Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if (pair.getKey().equals("roomSize"))
                        string.append("Size: " + pair.getValue());

                    if (pair.getKey().equals("roomPricePerNight"))
                        string.append(" Price: " + pair.getValue());
                }
                roomsList.addElement(string);
            }
        }
        return roomsList;
    }

    public ArrayList<LinkedHashMap> getAllRoomsHashMap() {
        return rooms.getAllRooms();
    }

    public void createRoom(String roomDescription, int roomSize, float roomDiscount, float roomPricePerNight) {
        rooms.insertUpdateRoom(0, roomDescription, roomSize, 0, roomDiscount, roomPricePerNight);
    }

    public void updateRoom(int roomID, String roomDescription, int roomSize, int roomStatus, float roomDiscount, float roomPricePerNight) {
        rooms.insertUpdateRoom(roomID, roomDescription, roomSize, roomStatus, roomDiscount, roomPricePerNight);
    }
}
