package guiLayer;

import com.michaelbaranov.microba.calendar.DatePicker;
import controlLayer.GUI.facilitiesController;
import controlLayer.GUI.startupController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class facilitiesBooking extends JPanel {
    private final DatePicker fromDatePicker;
    private final DatePicker toDatePicker;
    private controlLayer.GUI.facilitiesController facilitiesController = new facilitiesController();
    private controlLayer.GUI.startupController startupController = new startupController();

    public facilitiesBooking(final JFrame frame) {
        setLayout(null);
        setBounds(100, 100, 660, 430);
        setVisible(true);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(298, 160, 46, 14);

        JButton btnRoomBooking = new JButton("Room Booking");
        btnRoomBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Bookings Bookings = new Bookings(frame);
                frame.setContentPane(Bookings);
            }
        });
        btnRoomBooking.setBounds(10, 11, 120, 23);
        add(btnRoomBooking);

        JButton btnFacilitiesBooking = new JButton("Facilities Booking");
        btnFacilitiesBooking.setEnabled(false);
        btnFacilitiesBooking.setBounds(140, 11, 120, 23);
        add(btnFacilitiesBooking);

        JTextField loggedInUserInformation = new JTextField();
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

        JPanel facilitiesBookingPanel = new JPanel();
        tabbedPane.addTab("Fascilities Booking", null, facilitiesBookingPanel, null);
        facilitiesBookingPanel.setLayout(null);

        JLabel lblFacilities = new JLabel("Facilities:");
        lblFacilities.setBounds(10, 11, 71, 14);
        facilitiesBookingPanel.add(lblFacilities);

        JLabel lblGuest = new JLabel("Guest:");
        lblGuest.setBounds(10, 36, 71, 14);
        facilitiesBookingPanel.add(lblGuest);

        JLabel lblFromDate = new JLabel("From Date");
        lblFromDate.setBounds(10, 61, 71, 14);
        facilitiesBookingPanel.add(lblFromDate);

        JLabel lblToDate = new JLabel("To Date");
        lblToDate.setBounds(10, 86, 71, 14);
        facilitiesBookingPanel.add(lblToDate);

        JComboBox comboBoxRooms = new JComboBox();
        comboBoxRooms.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        comboBoxRooms.setBounds(91, 8, 385, 20);
        facilitiesBookingPanel.add(comboBoxRooms);

        JComboBox comboBoxGuests = new JComboBox();
        comboBoxGuests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        comboBoxGuests.setBounds(91, 33, 385, 20);
        facilitiesBookingPanel.add(comboBoxGuests);

        fromDatePicker = new DatePicker(new Date());
        fromDatePicker.setBounds(91, 58, 385, 20);
        facilitiesBookingPanel.add(fromDatePicker);

        fromDatePicker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(fromDatePicker.getDate());
            }
        });

        toDatePicker = new DatePicker(new Date());
        toDatePicker.setBounds(91, 83, 385, 20);
        facilitiesBookingPanel.add(toDatePicker);

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
        facilitiesBookingPanel.add(btnCreateBooking);

        //// Facilities
        JPanel facilitiesPanel = new JPanel();
        tabbedPane.addTab("Facilities", null, facilitiesPanel, null);
        facilitiesPanel.setLayout(null);

        JTextPane textPaneFacilitiesInformation = new JTextPane();
        textPaneFacilitiesInformation.setBounds(267, 29, 332, 245);
        textPaneFacilitiesInformation.setEnabled(false);
        facilitiesPanel.add(textPaneFacilitiesInformation);

        // Show all facilities on the hotel in a list, and also populate the text for the textPane
        JList listFacilities = new JList(facilitiesController.getAllFacilitiesListModel());
        ArrayList<LinkedHashMap> allFacilities = facilitiesController.getAllFacilitiesHashMap();
        listFacilities.setVisibleRowCount(200);
        listFacilities.setBounds(10, 11, 247, 294);
        listFacilities.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedID = listFacilities.getSelectedIndex();
                LinkedHashMap facilityInfo = allFacilities.get(selectedID);
                StringBuilder text = new StringBuilder();
                for(Object element : facilityInfo.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    text.append(pair.getKey() + ": " + pair.getValue() + "\n");
                }
                textPaneFacilitiesInformation.setText(text.toString());
            }
        });
        facilitiesPanel.add(listFacilities);

        JLabel labelGuestInformation = new JLabel("Facility Information");
        labelGuestInformation.setBounds(267, 12, 160, 14);
        facilitiesPanel.add(labelGuestInformation);

        JButton btnCreateGuest = new JButton("Create");
        btnCreateGuest.setBounds(277, 282, 89, 23);
        btnCreateGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        facilitiesPanel.add(btnCreateGuest);

        JButton btnEditGuest = new JButton("Edit");
        btnEditGuest.setBounds(376, 282, 89, 23);
        btnEditGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        facilitiesPanel.add(btnEditGuest);

        JButton btnDeleteGuest = new JButton("Delete");
        btnDeleteGuest.setBounds(475, 282, 89, 23);
        btnDeleteGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: ");
            }
        });
        facilitiesPanel.add(btnDeleteGuest);
    }
}