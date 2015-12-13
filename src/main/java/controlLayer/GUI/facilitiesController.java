package controlLayer.GUI;

import modelLayer.Facilities;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

// Return all facilities as a DefaultListModel
public class facilitiesController {
    // Load the Facilities Model
    Facilities facilities = new Facilities();

    // Return a DefaultListModel for JList
    public DefaultListModel getAllFacilitiesListModel() {
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
    }


}
