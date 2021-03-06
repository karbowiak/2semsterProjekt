package controlLayer.GUI;

import modelLayer.Person;
import modelLayer.roomBookingGuests;
import tools.QuickHash;
import tools.databaseQuery;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class guestsController {
    // Load the Guests model
    Person person = new Person();
    roomBookingGuests roomBookingGuests = new roomBookingGuests();

    public DefaultListModel getAllGuestsListModel() {
        ArrayList<LinkedHashMap> allGuests = person.getAllPersons();
        DefaultListModel guestsList = new DefaultListModel<String>();

        if(allGuests != null) {
            for (LinkedHashMap map : allGuests) {
                StringBuilder string = new StringBuilder();
                for (Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if (pair.getKey().equals("personFirstName"))
                        string.append(pair.getValue() + " ");

                    if (pair.getKey().equals("personLastName"))
                        string.append(pair.getValue() + " | ");

                    if (pair.getKey().equals("personPassportInformation"))
                        string.append("Passport: " + pair.getValue());
                }
                guestsList.addElement(string);
            }
        }
        return guestsList;
    }

    public ArrayList<LinkedHashMap> getAllGuestsHashMap() {
        return person.getAllPersons();
    }

    public DefaultComboBoxModel getAllGuestsComboBoxModel() {
        ArrayList<LinkedHashMap> allGuests = person.getAllPersons();
        DefaultComboBoxModel guestsList = new DefaultComboBoxModel<String>();

        if(allGuests != null) {
            for (LinkedHashMap map : allGuests) {
                StringBuilder string = new StringBuilder();
                for (Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if (pair.getKey().equals("personFirstName"))
                        string.append(pair.getValue() + " ");

                    if (pair.getKey().equals("personLastName"))
                        string.append(pair.getValue() + " | ");

                    if (pair.getKey().equals("personPassportInformation"))
                        string.append("Passport: " + pair.getValue());
                }
                guestsList.addElement(string);
            }
        }
        return guestsList;
    }

    public void addGuestToBooking(int bookingID, int guestID) {
        roomBookingGuests.insertRoomGuestBooking(bookingID, guestID);
    }

    public void createGuest(String personFirstName, String personLastName, String personAddress, String personPassportInformation, String personPhoneNumber, String personEMail, String personBirthDate, String personFromCountry) {
        person.insertUpdatePerson(0, personFirstName, personLastName, personAddress, personPassportInformation, personPhoneNumber, personEMail, personBirthDate, personFromCountry, 1, null);
    }

    public void updateGuest(int personID, String personFirstName, String personLastName, String personAddress, String personPassportInformation, String personPhoneNumber, String personEMail, String personBirthDate, String personFromCountry, int personType, String personFunction) {
        person.insertUpdatePerson(personID, personFirstName, personLastName, personAddress, personPassportInformation, personPhoneNumber, personEMail, personBirthDate, personFromCountry, personType, personFunction);
    }

    public void deleteGuest(int personID) {
        person.deletePerson(personID);
    }
}
