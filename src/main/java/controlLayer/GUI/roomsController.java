package controlLayer.GUI;

import modelLayer.Facilities;
import modelLayer.Rooms;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// Return all facilities as a DefaultListModel
public class roomsController {
    // Load the Rooms model
    Rooms rooms = new Rooms();

    //public DefaultListModel getAllRoomsListModel() {
        //ArrayList<LinkedHashMap> allRooms =
    //}
    // Return a DefaultListModel for JList
    /*public DefaultListModel getAllFacilitiesListModel() {
        ArrayList<LinkedHashMap> allFacilities = facilities.getAllFacilities();
        DefaultListModel facilitiesList = new DefaultListModel<String>();

        for (LinkedHashMap map : allFacilities) {
            for(Object element : map.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("facilityType"))
                    facilitiesList.addElement(pair.getValue());
            }
        }

        return facilitiesList;
    }

    // Return the arraylist/hashmap of all facilities
    public ArrayList<LinkedHashMap> getAllFacilitiesHashMap() {
        ArrayList<LinkedHashMap> allFacilities = facilities.getAllFacilities();
        return allFacilities;
    }*/


}
