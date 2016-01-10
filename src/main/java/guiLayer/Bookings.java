package guiLayer;

import com.michaelbaranov.microba.calendar.DatePicker;
import controlLayer.GUI.guestsController;
import controlLayer.GUI.bookingsController;
import controlLayer.GUI.roomsController;
import controlLayer.GUI.startupController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bookings extends JPanel {
    private DatePicker fromDatePicker;
    private DatePicker toDatePicker;
    private controlLayer.GUI.roomsController roomsController = new roomsController();
    private controlLayer.GUI.guestsController guestsController = new guestsController();
    private bookingsController bookingsController = new bookingsController();

    // Booking creation
    private DefaultComboBoxModel unrentedRoomsList = bookingsController.getAllUnrentedRoomsComboBox();
    private DefaultComboBoxModel guestComboBoxModelList = guestsController.getAllGuestsComboBoxModel();
    private ArrayList<LinkedHashMap> unrentedRoomsListHashMap = bookingsController.getAllUnrentedRoomsHashMap();
    private ArrayList<LinkedHashMap> guestArrayListLinkedHashMap = guestsController.getAllGuestsHashMap();
    private int selectedRoom;
    private int selectedGuest;
    private String selectedFromDate;
    private String selectedToDate;
    private int selectedRoomID;
    private int selectedGuestID;

    // Rentals data
    private DefaultListModel rentalsListModel = bookingsController.getAllRoomBookingsListModel();
    private ArrayList<LinkedHashMap> rentalsAll = bookingsController.getAllBookingsHashMap();
    private int rentalSelectedID;

    // Guests data
    private DefaultListModel guestsListModel = guestsController.getAllGuestsListModel();
    private ArrayList<LinkedHashMap> guestsAll = guestsController.getAllGuestsHashMap();
    private int guestSelectedID;

    // Rooms data
    private DefaultListModel roomsListModel = roomsController.getAllRoomsListModel();
    private ArrayList<LinkedHashMap> roomsAll = roomsController.getAllRoomsHashMap();
    private int roomSelectedID;

    public Bookings(final JFrame frame) {
        setLayout(null);
        setBounds(100, 100, 660, 430);
        setVisible(true);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(298, 160, 46, 14);

        JButton btnRoomBooking = new JButton("Room Booking");
        btnRoomBooking.setEnabled(false);
        btnRoomBooking.setBounds(10, 11, 120, 23);
        add(btnRoomBooking);

        JButton btnFacilitiesBooking = new JButton("Facilities Booking");
        btnFacilitiesBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                facilitiesBooking facilitiesBooking = new facilitiesBooking(frame);
                frame.setContentPane(facilitiesBooking);
            }
        });
        btnFacilitiesBooking.setBounds(140, 11, 120, 23);
        add(btnFacilitiesBooking);

        JTextField loggedInUserInformation = new JTextField();
        controlLayer.GUI.startupController startupController = new startupController();
        loggedInUserInformation.setText(startupController.getLoggedInUserName() + " / " + startupController.getLoggedInUserID());
        loggedInUserInformation.setBounds(332, 12, 302, 20);
        loggedInUserInformation.setEnabled(false);
        add(loggedInUserInformation);
        loggedInUserInformation.setColumns(10);

        JLabel lblLoggedIn = new JLabel("Logged In:");
        lblLoggedIn.setBounds(270, 15, 52, 14);
        add(lblLoggedIn);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(567, 32, 67, 23);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        add(btnLogout);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(20, 45, 614, 344);
        add(tabbedPane);

        JPanel roomBookingPanel = new JPanel();
        tabbedPane.addTab("Room Booking", null, roomBookingPanel, null);
        roomBookingPanel.setLayout(null);

        JLabel lblRoom = new JLabel("Room:");
        lblRoom.setBounds(10, 11, 71, 14);
        roomBookingPanel.add(lblRoom);

        JLabel lblGuest = new JLabel("Guest:");
        lblGuest.setBounds(10, 36, 71, 14);
        roomBookingPanel.add(lblGuest);

        JLabel lblFromDate = new JLabel("From Date");
        lblFromDate.setBounds(10, 61, 71, 14);
        roomBookingPanel.add(lblFromDate);

        JLabel lblToDate = new JLabel("To Date");
        lblToDate.setBounds(10, 86, 71, 14);
        roomBookingPanel.add(lblToDate);

        JComboBox comboBoxRooms = new JComboBox(unrentedRoomsList);
        comboBoxRooms.addActionListener(e -> {
            selectedRoomID = comboBoxRooms.getSelectedIndex();
            LinkedHashMap roomInfo = unrentedRoomsListHashMap.get(selectedRoomID);
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("roomID"))
                    selectedRoom = Integer.valueOf(String.valueOf(pair.getValue()));
            }
        });
        comboBoxRooms.setBounds(91, 8, 385, 20);
        roomBookingPanel.add(comboBoxRooms);

        JComboBox comboBoxGuests = new JComboBox(guestComboBoxModelList);
        comboBoxGuests.addActionListener(e -> {
            selectedGuestID = comboBoxRooms.getSelectedIndex();
            LinkedHashMap personInfo = guestArrayListLinkedHashMap.get(selectedGuestID);
            for (Object element : personInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("personID"))
                    selectedGuest = Integer.valueOf(String.valueOf(pair.getValue())); // Why isn't it setting the selectedGuest (personID) correctly 90% of the time?
            }
        });
        comboBoxGuests.setBounds(91, 33, 385, 20);
        roomBookingPanel.add(comboBoxGuests);

        fromDatePicker = new DatePicker(new Date());
        fromDatePicker.setBounds(91, 58, 385, 20);
        roomBookingPanel.add(fromDatePicker);

        fromDatePicker.addActionListener(e -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            selectedFromDate = dateFormat.format(fromDatePicker.getDate());
        });

        toDatePicker = new DatePicker(new Date());
        toDatePicker.setBounds(91, 83, 385, 20);
        roomBookingPanel.add(toDatePicker);

        toDatePicker.addActionListener(e -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            selectedToDate = dateFormat.format(toDatePicker.getDate());
        });

        JButton btnCreateBooking = new JButton("Create Booking");
        btnCreateBooking.setBounds(362, 109, 115, 30);
        btnCreateBooking.addActionListener(e -> {
            // Insert
            bookingsController.createBooking(selectedRoom, 1, selectedFromDate, selectedToDate, 1);
            // Get the booking ID
            int bookingID = Integer.valueOf(bookingsController.getBookingID(selectedRoom, 1, selectedFromDate, selectedToDate, 1));
            // Insert the guest to the roomBookingGuests table
            guestsController.addGuestToBooking(bookingID, selectedGuest);
        });
        roomBookingPanel.add(btnCreateBooking);

        //// Rentals
        JPanel rentals = new JPanel();
        tabbedPane.addTab("Rentals", null, rentals, null);
        rentals.setLayout(null);

        JTextPane textPaneRentalInformation = new JTextPane();
        textPaneRentalInformation.setBounds(267, 29, 332, 245);
        textPaneRentalInformation.setEnabled(false);
        rentals.add(textPaneRentalInformation);

        JList listRentals = new JList(rentalsListModel);
        listRentals.setVisibleRowCount(200);
        listRentals.setBounds(10, 11, 247, 294);
        listRentals.addListSelectionListener(e -> {
            rentalSelectedID = listRentals.getSelectedIndex();
            LinkedHashMap roomInfo = rentalsAll.get(rentalSelectedID);
            StringBuilder text = new StringBuilder();
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                text.append(pair.getKey() + ": " + pair.getValue() + "\n");
            }
            textPaneRentalInformation.setText(text.toString());
        });

        rentals.add(listRentals);

        JLabel labelRentalInformation = new JLabel("Rental Information");
        labelRentalInformation.setBounds(267, 12, 160, 14);
        rentals.add(labelRentalInformation);

        JButton btnCreateRental = new JButton("Create");
        btnCreateRental.setBounds(277, 282, 89, 23);
        btnCreateRental.addActionListener(e -> {
            JTextField roomID = new JTextField();
            JTextField bookingBureau = new JTextField();
            JTextField fromDate = new JTextField();
            JTextField toDate = new JTextField();
            JTextField employeeID = new JTextField();
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("RoomID (int)"));
            panel.add(roomID);
            panel.add(new JLabel("Booking Bureau (int)"));
            panel.add(bookingBureau);
            panel.add(new JLabel("From Date (2015-01-01 00:00:00)"));
            panel.add(fromDate);
            panel.add(new JLabel("To Date (2015-01-01 00:00:00)"));
            panel.add(toDate);
            panel.add(new JLabel("EmployeeID (int)"));
            panel.add(employeeID);

            int result = JOptionPane.showConfirmDialog(null, panel, "Create Booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if(result == JOptionPane.OK_OPTION) {
                // Insert it to the database
                bookingsController.createBooking(Integer.valueOf(roomID.getText()), Integer.valueOf(bookingBureau.getText()), fromDate.getText(), toDate.getText(), Integer.valueOf(employeeID.getText()));
                rentalsListModel = bookingsController.getAllRoomBookingsListModel();
                rentalsAll = bookingsController.getAllBookingsHashMap();
                listRentals.setModel(rentalsListModel);
            }
        });
        rentals.add(btnCreateRental);

        JButton btnEditRental = new JButton("Edit");
        btnEditRental.setBounds(376, 282, 89, 23);
        btnEditRental.addActionListener(new ActionListener() {
            JTextField bookingID;
            JTextField roomID;
            JTextField bookingBureau;
            JTextField fromDate;
            JTextField toDate;
            JTextField checkinDate;
            JTextField checkoutDate;
            JTextField priceBeforeDiscount;
            JTextField discount;
            JTextField totalPrice;
            JTextField employeeID;
            JTextField bookingActive;

            public void actionPerformed(ActionEvent e) {
                LinkedHashMap rentalInfo = rentalsAll.get(rentalSelectedID);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                for (Object element : rentalInfo.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    // See, now it would be nice with fucking dynamic variable creation, but can java do this?
                    // nooooooooooo.. because java is a shit language, only used by shit people...............
                    if(pair.getKey().equals("bookingID")) {
                        bookingID = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(bookingID);
                    }
                    if(pair.getKey().equals("roomID")) {
                        roomID = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomID);
                    }
                    if(pair.getKey().equals("bookingBureau")) {
                        bookingBureau = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(bookingBureau);
                    }
                    if(pair.getKey().equals("fromDate")) {
                        fromDate = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(fromDate);
                    }
                    if(pair.getKey().equals("toDate")) {
                        toDate = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(toDate);
                    }
                    if(pair.getKey().equals("checkinDate")) {
                        checkinDate = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(checkinDate);
                    }
                    if(pair.getKey().equals("checkoutDate")) {
                        checkoutDate = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(checkoutDate);
                    }
                    if(pair.getKey().equals("priceBeforeDiscount")) {
                        priceBeforeDiscount = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(priceBeforeDiscount);
                    }
                    if(pair.getKey().equals("discount")) {
                        discount = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(discount);
                    }
                    if(pair.getKey().equals("totalPrice")) {
                        totalPrice = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(totalPrice);
                    }
                    if(pair.getKey().equals("employeeID")) {
                        employeeID = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(employeeID);
                    }
                    if(pair.getKey().equals("bookingActive")) {
                        bookingActive = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(bookingActive);
                    }
                }
                int result = JOptionPane.showConfirmDialog(null, panel, "Update Rental", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if(result == JOptionPane.OK_OPTION) {
                    // Insert it to the database
                    bookingsController.updateBooking(Integer.valueOf(bookingID.getText()), Integer.valueOf(roomID.getText()), Integer.valueOf(bookingBureau.getText()), fromDate.getText(), toDate.getText(), checkinDate.getText(), checkoutDate.getText(), Float.valueOf(priceBeforeDiscount.getText()), Float.valueOf(discount.getText()), Float.valueOf(totalPrice.getText()), Integer.valueOf(employeeID.getText()), Integer.valueOf(bookingActive.getText()));
                    rentalsListModel = bookingsController.getAllRoomBookingsListModel();
                    rentalsAll = bookingsController.getAllBookingsHashMap();
                    listRentals.setModel(rentalsListModel);
                }
            }
        });
        rentals.add(btnEditRental);

        JButton btnDeleteRental = new JButton("Delete");
        btnDeleteRental.setBounds(475, 282, 89, 23);
        btnDeleteRental.addActionListener(e -> {
            rentalSelectedID = listRentals.getSelectedIndex();
            LinkedHashMap roomInfo = rentalsAll.get(rentalSelectedID);
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("bookingID"))
                    bookingsController.deleteBooking(Integer.valueOf(String.valueOf(pair.getValue())));
            }
            rentalsListModel = bookingsController.getAllRoomBookingsListModel();
            rentalsAll = bookingsController.getAllBookingsHashMap();
            listRentals.setModel(rentalsListModel);
        });
        rentals.add(btnDeleteRental);

        //// Guests
        JPanel guestsPanel = new JPanel();
        tabbedPane.addTab("Guests", null, guestsPanel, null);
        guestsPanel.setLayout(null);

        JTextPane textPaneGuestInformation = new JTextPane();
        textPaneGuestInformation.setBounds(267, 29, 332, 245);
        textPaneGuestInformation.setEnabled(false);
        guestsPanel.add(textPaneGuestInformation);

        JList listGuests = new JList(guestsListModel);
        listGuests.setVisibleRowCount(200);
        listGuests.setBounds(10, 11, 247, 294);
        listGuests.addListSelectionListener(e -> {
            guestSelectedID = listGuests.getSelectedIndex();
            LinkedHashMap roomInfo = guestsAll.get(guestSelectedID);
            StringBuilder text = new StringBuilder();
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                text.append(pair.getKey() + ": " + pair.getValue() + "\n");
            }
            textPaneGuestInformation.setText(text.toString());
        });
        guestsPanel.add(listGuests);

        JLabel labelGuestInformation = new JLabel("Guest Information");
        labelGuestInformation.setBounds(267, 12, 160, 14);
        guestsPanel.add(labelGuestInformation);

        JButton btnCreateGuest = new JButton("Create");
        btnCreateGuest.setBounds(277, 282, 89, 23);
        btnCreateGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField personFirstName = new JTextField();
                JTextField personLastName = new JTextField();
                JTextField personAddress = new JTextField();
                JTextField personPassportInformation = new JTextField();
                JTextField personPhoneNumber = new JTextField();
                JTextField personEMail = new JTextField();
                JTextField personBirthDate = new JTextField();
                JTextField personFromCountry = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("First Name (string)"));
                panel.add(personFirstName);
                panel.add(new JLabel("Last Name (string)"));
                panel.add(personLastName);
                panel.add(new JLabel("Address (string)"));
                panel.add(personAddress);
                panel.add(new JLabel("Passport Information (string)"));
                panel.add(personPassportInformation);
                panel.add(new JLabel("Phone Number (string)"));
                panel.add(personPhoneNumber);
                panel.add(new JLabel("EMail Address (string)"));
                panel.add(personEMail);
                panel.add(new JLabel("Birth Date (string)"));
                panel.add(personBirthDate);
                panel.add(new JLabel("Country of Origin (string)"));
                panel.add(personFromCountry);

                int result = JOptionPane.showConfirmDialog(null, panel, "Create Booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if(result == JOptionPane.OK_OPTION) {
                    // Insert it to the database
                    guestsController.createGuest(personFirstName.getText(), personLastName.getText(), personAddress.getText(), personPassportInformation.getText(), personPhoneNumber.getText(), personEMail.getText(), personBirthDate.getText(), personFromCountry.getText());
                    guestsListModel = guestsController.getAllGuestsListModel();
                    guestsAll = guestsController.getAllGuestsHashMap();
                    listGuests.setModel(guestsListModel);
                }
            }
        });
        guestsPanel.add(btnCreateGuest);

        JButton btnEditGuest = new JButton("Edit");
        btnEditGuest.setBounds(376, 282, 89, 23);
        btnEditGuest.addActionListener(new ActionListener() {
            JTextField personID;
            JTextField personFirstName;
            JTextField personLastName;
            JTextField personAddress;
            JTextField personPassportInformation;
            JTextField personPhoneNumber;
            JTextField personEMail;
            JTextField personBirthDate;
            JTextField personFromCountry;
            JTextField personType;
            JTextField personFunction;

            public void actionPerformed(ActionEvent e) {
                LinkedHashMap guestInfo = guestsAll.get(guestSelectedID);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                for (Object element : guestInfo.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    // See, now it would be nice with fucking dynamic variable creation, but can java do this?
                    // nooooooooooo.. because java is a shit language, only used by shit people...............
                    if(pair.getKey().equals("personID")) {
                        personID = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personID);
                    }
                    if(pair.getKey().equals("personFirstName")) {
                        personFirstName = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personFirstName);
                    }
                    if(pair.getKey().equals("personLastName")) {
                        personLastName = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personLastName);
                    }
                    if(pair.getKey().equals("personAddress")) {
                        personAddress = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personAddress);
                    }
                    if(pair.getKey().equals("personPassportInformation")) {
                        personPassportInformation = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personPassportInformation);
                    }
                    if(pair.getKey().equals("personPhoneNumber")) {
                        personPhoneNumber = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personPhoneNumber);
                    }
                    if(pair.getKey().equals("personEMail")) {
                        personEMail = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personEMail);
                    }
                    if(pair.getKey().equals("personBirthDate")) {
                        personBirthDate = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personBirthDate);
                    }
                    if(pair.getKey().equals("personFromCountry")) {
                        personFromCountry = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personFromCountry);
                    }
                    if(pair.getKey().equals("personType")) {
                        personType = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personType);
                    }
                    if(pair.getKey().equals("personFunction")) {
                        personFunction = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(personFunction);
                    }
                }
                int result = JOptionPane.showConfirmDialog(null, panel, "Update Guest", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if(result == JOptionPane.OK_OPTION) {
                    // Insert it to the database
                    guestsController.updateGuest(Integer.valueOf(personID.getText()), personFirstName.getText(), personLastName.getText(), personAddress.getText(), personPassportInformation.getText(), personPhoneNumber.getText(), personEMail.getText(), personBirthDate.getText(), personFromCountry.getText(), Integer.valueOf(personType.getText()), personFunction.getText());
                    guestsListModel = guestsController.getAllGuestsListModel();
                    guestsAll = guestsController.getAllGuestsHashMap();
                    listGuests.setModel(guestsListModel);
                }
            }
        });
        guestsPanel.add(btnEditGuest);

        JButton btnDeleteGuest = new JButton("Delete");
        btnDeleteGuest.setBounds(475, 282, 89, 23);
        btnDeleteGuest.addActionListener(e -> {
            // Delete based on the roomSelectedID
            guestSelectedID = listGuests.getSelectedIndex();
            LinkedHashMap roomInfo = guestsAll.get(guestSelectedID);
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("personID"))
                    guestsController.deleteGuest(Integer.valueOf(String.valueOf(pair.getValue())));
            }
            guestsListModel = guestsController.getAllGuestsListModel();
            guestsAll = guestsController.getAllGuestsHashMap();
            listGuests.setModel(guestsListModel);
        });
        guestsPanel.add(btnDeleteGuest);

        //// Rooms
        JPanel roomsPanel = new JPanel();
        tabbedPane.addTab("Rooms", null, roomsPanel, null);
        roomsPanel.setLayout(null);

        JTextPane textPaneRoomInformation = new JTextPane();
        textPaneRoomInformation.setBounds(267, 29, 332, 245);
        textPaneRoomInformation.setEnabled(false);
        roomsPanel.add(textPaneRoomInformation);

        JList listRooms = new JList(roomsListModel);
        listRooms.setVisibleRowCount(200);
        listRooms.setBounds(10, 11, 247, 294);
        listRooms.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                roomSelectedID = listRooms.getSelectedIndex();
                LinkedHashMap roomInfo = roomsAll.get(roomSelectedID);
                StringBuilder text = new StringBuilder();
                for (Object element : roomInfo.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    text.append(pair.getKey() + ": " + pair.getValue() + "\n");
                }
                textPaneRoomInformation.setText(text.toString());
            }
        });
        roomsPanel.add(listRooms);

        JLabel labelRoomInformation = new JLabel("Room Information");
        labelRoomInformation.setBounds(267, 12, 160, 14);
        roomsPanel.add(labelRoomInformation);

        JButton btnCreateRoom = new JButton("Create");
        btnCreateRoom.setBounds(277, 282, 89, 23);
        btnCreateRoom.addActionListener(e -> {
            JTextField roomDescription = new JTextField();
            JTextField roomSize = new JTextField();
            JTextField roomDiscount = new JTextField();
            JTextField roomPricePerNight = new JTextField();
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Room Description (string)"));
            panel.add(roomDescription);
            panel.add(new JLabel("Room Size (int)"));
            panel.add(roomSize);
            panel.add(new JLabel("Room Discount (float)"));
            panel.add(roomDiscount);
            panel.add(new JLabel("Room Price Per Night (float)"));
            panel.add(roomPricePerNight);
            int result = JOptionPane.showConfirmDialog(null, panel, "Create Room", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if(result == JOptionPane.OK_OPTION) {
                // Insert it to the database
                roomsController.createRoom(roomDescription.getText(), Integer.valueOf(roomSize.getText()), Float.parseFloat(roomDiscount.getText()), Float.parseFloat(roomPricePerNight.getText()));
                roomsListModel = roomsController.getAllRoomsListModel();
                roomsAll = roomsController.getAllRoomsHashMap();
                listRooms.setModel(roomsListModel);
            }
        });
        roomsPanel.add(btnCreateRoom);

        JButton btnEditRoom = new JButton("Edit");
        btnEditRoom.setBounds(376, 282, 89, 23);
        btnEditRoom.addActionListener(new ActionListener() {
            JTextField roomID;
            JTextField roomDescription;
            JTextField roomSize;
            JTextField roomStatus;
            JTextField roomDiscount;
            JTextField roomPricePerNight;

            public void actionPerformed(ActionEvent e) {
                LinkedHashMap roomInfo = roomsAll.get(roomSelectedID);
                JPanel panel = new JPanel(new GridLayout(0, 1));
                for (Object element : roomInfo.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    // See, now it would be nice with fucking dynamic variable creation, but can java do this?
                    // nooooooooooo.. because java is a shit language, only used by shit people...............
                    if(pair.getKey().equals("roomID")) {
                        roomID = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomID);
                    }
                    if(pair.getKey().equals("roomDescription")) {
                        roomDescription = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomDescription);
                    }
                    if(pair.getKey().equals("roomSize")) {
                        roomSize = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomSize);
                    }
                    if(pair.getKey().equals("roomStatus")) {
                        roomStatus = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomStatus);
                    }
                    if(pair.getKey().equals("roomDiscount")) {
                        roomDiscount = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomDiscount);
                    }
                    if(pair.getKey().equals("roomPricePerNight")) {
                        roomPricePerNight = new JTextField(String.valueOf(pair.getValue()));
                        panel.add(new JLabel(pair.getKey() + ":"));
                        panel.add(roomPricePerNight);
                    }
                }
                int result = JOptionPane.showConfirmDialog(null, panel, "Update Room", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if(result == JOptionPane.OK_OPTION) {
                    // Insert it to the database
                    roomsController.updateRoom(Integer.valueOf(roomID.getText()), roomDescription.getText(), Integer.valueOf(roomSize.getText()), Integer.valueOf(roomStatus.getText()), Float.parseFloat(roomDiscount.getText()), Float.parseFloat(roomPricePerNight.getText()));
                    roomsListModel = roomsController.getAllRoomsListModel();
                    roomsAll = roomsController.getAllRoomsHashMap();
                    listRooms.setModel(roomsListModel);
                }
            }
        });
        roomsPanel.add(btnEditRoom);

        JButton btnDeleteRoom = new JButton("Delete");
        btnDeleteRoom.setBounds(475, 282, 89, 23);
        btnDeleteRoom.addActionListener(e -> {
            // Delete based on the roomSelectedID
            roomSelectedID = listRooms.getSelectedIndex();
            LinkedHashMap roomInfo = roomsAll.get(roomSelectedID);
            for (Object element : roomInfo.entrySet()) {
                Map.Entry pair = (Map.Entry) element;
                if(pair.getKey().equals("roomID"))
                    roomsController.deleteRoom(Integer.valueOf(String.valueOf(pair.getValue())));
            }
            roomsListModel = roomsController.getAllRoomsListModel();
            roomsAll = roomsController.getAllRoomsHashMap();
            listRooms.setModel(roomsListModel);
        });
        roomsPanel.add(btnDeleteRoom);
    }
}