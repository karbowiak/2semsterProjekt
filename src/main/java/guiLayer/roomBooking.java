package guiLayer;

import com.michaelbaranov.microba.calendar.DatePicker;
import controlLayer.GUI.roomsController;
import controlLayer.GUI.startupController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class roomBooking extends JPanel {
    private JTextField loggedInUserInformation;
    private DatePicker fromDatePicker;
    private DatePicker toDatePicker;
    private controlLayer.GUI.startupController startupController = new startupController();
    private controlLayer.GUI.roomsController roomsController = new roomsController();

    // Rooms list data
    private DefaultListModel roomsListModel = roomsController.getAllRoomsListModel();
    private ArrayList<LinkedHashMap> roomsAll = roomsController.getAllRoomsHashMap();

    public roomBooking(final JFrame frame) {
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

        loggedInUserInformation = new JTextField();
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

        JComboBox comboBoxRooms = new JComboBox();
        comboBoxRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        comboBoxRooms.setBounds(91, 8, 385, 20);
        roomBookingPanel.add(comboBoxRooms);

        JComboBox comboBoxGuests = new JComboBox();
        comboBoxGuests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        comboBoxGuests.setBounds(91, 33, 385, 20);
        roomBookingPanel.add(comboBoxGuests);

        fromDatePicker = new DatePicker(new Date());
        fromDatePicker.setBounds(91, 58, 385, 20);
        roomBookingPanel.add(fromDatePicker);

        fromDatePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(fromDatePicker.getDate());
            }
        });

        toDatePicker = new DatePicker(new Date());
        toDatePicker.setBounds(91, 83, 385, 20);
        roomBookingPanel.add(toDatePicker);

        toDatePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(toDatePicker.getDate());
            }
        });

        JButton btnCreateBooking = new JButton("Create Booking");
        btnCreateBooking.setBounds(362, 109, 115, 30);
        btnCreateBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        roomBookingPanel.add(btnCreateBooking);

        //// Rentals
        JPanel rentals = new JPanel();
        tabbedPane.addTab("Rentals", null, rentals, null);
        rentals.setLayout(null);

        JList listRentals = new JList();
        listRentals.setVisibleRowCount(200);
        listRentals.setBounds(10, 11, 247, 294);
        listRentals.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

            }
        });

        rentals.add(listRentals);

        JTextPane textPaneRentalInformation = new JTextPane();
        textPaneRentalInformation.setBounds(267, 29, 332, 245);
        textPaneRentalInformation.setEnabled(false);
        rentals.add(textPaneRentalInformation);

        JLabel labelRentalInformation = new JLabel("Rental Information");
        labelRentalInformation.setBounds(267, 12, 160, 14);
        rentals.add(labelRentalInformation);

        JButton btnCreateRental = new JButton("Create");
        btnCreateRental.setBounds(277, 282, 89, 23);
        btnCreateRental.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        rentals.add(btnCreateRental);

        JButton btnEditRental = new JButton("Edit");
        btnEditRental.setBounds(376, 282, 89, 23);
        btnEditRental.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        rentals.add(btnEditRental);

        JButton btnDeleteRental = new JButton("Delete");
        btnDeleteRental.setBounds(475, 282, 89, 23);
        btnDeleteRental.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        rentals.add(btnDeleteRental);

        //// Guests
        JPanel guestsPanel = new JPanel();
        tabbedPane.addTab("Guests", null, guestsPanel, null);
        guestsPanel.setLayout(null);

        JList listGuests = new JList();
        listGuests.setVisibleRowCount(200);
        listGuests.setBounds(10, 11, 247, 294);
        listGuests.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

            }
        });
        guestsPanel.add(listGuests);

        JTextPane textPaneGuestInformation = new JTextPane();
        textPaneGuestInformation.setBounds(267, 29, 332, 245);
        textPaneGuestInformation.setEnabled(false);
        guestsPanel.add(textPaneGuestInformation);

        JLabel labelGuestInformation = new JLabel("Guest Information");
        labelGuestInformation.setBounds(267, 12, 160, 14);
        guestsPanel.add(labelGuestInformation);

        JButton btnCreateGuest = new JButton("Create");
        btnCreateGuest.setBounds(277, 282, 89, 23);
        btnCreateGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        guestsPanel.add(btnCreateGuest);

        JButton btnEditGuest = new JButton("Edit");
        btnEditGuest.setBounds(376, 282, 89, 23);
        btnEditGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        guestsPanel.add(btnEditGuest);

        JButton btnDeleteGuest = new JButton("Delete");
        btnDeleteGuest.setBounds(475, 282, 89, 23);
        btnDeleteGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
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
                int selectedID = listRooms.getSelectedIndex();
                LinkedHashMap roomInfo = roomsAll.get(selectedID);
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
        btnCreateRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    listRooms.setVisible(false);
                    listRooms.setVisible(true);
                }
            }
        });
        roomsPanel.add(btnCreateRoom);

        JButton btnEditRoom = new JButton("Edit");
        btnEditRoom.setBounds(376, 282, 89, 23);
        btnEditRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        roomsPanel.add(btnEditRoom);

        JButton btnDeleteRoom = new JButton("Delete");
        btnDeleteRoom.setBounds(475, 282, 89, 23);
        btnDeleteRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        roomsPanel.add(btnDeleteRoom);
    }
}