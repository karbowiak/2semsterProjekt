package guiLayer;

import com.michaelbaranov.microba.calendar.DatePicker;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class roomBooking extends JPanel {
    private JTextField loggedInUserInformation;
    public DatePicker fromDatePicker;
    public DatePicker toDatePicker;

    public roomBooking() {
        setLayout(null);
        setBounds(100, 100, 660, 430);
        setVisible(true);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(298, 160, 46, 14);

        JButton btnRoomBooking = new JButton("Room Booking");
        btnRoomBooking.setEnabled(false);
        btnRoomBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRoomBooking.setBounds(10, 11, 120, 23);
        add(btnRoomBooking);

        JButton btnFacilitiesBooking = new JButton("Facilities Booking");
        btnFacilitiesBooking.setBounds(140, 11, 120, 23);
        add(btnFacilitiesBooking);

        loggedInUserInformation = new JTextField();
        loggedInUserInformation.setBounds(332, 12, 302, 20);
        add(loggedInUserInformation);
        loggedInUserInformation.setColumns(10);

        JLabel lblLoggedIn = new JLabel("Logged In:");
        lblLoggedIn.setBounds(270, 15, 52, 14);
        add(lblLoggedIn);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(567, 32, 67, 23);
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

        JPanel guestsPanel = new JPanel();
        tabbedPane.addTab("Guests", null, guestsPanel, null);
        guestsPanel.setLayout(null);

        JList listGuests = new JList();
        listGuests.setVisibleRowCount(200);
        listGuests.setBounds(10, 11, 247, 294);
        guestsPanel.add(listGuests);

        JTextPane textPaneGuestInformation = new JTextPane();
        textPaneGuestInformation.setBounds(267, 29, 332, 245);
        guestsPanel.add(textPaneGuestInformation);

        JLabel labelGuestInformation = new JLabel("Guest Information");
        labelGuestInformation.setBounds(267, 12, 160, 14);
        guestsPanel.add(labelGuestInformation);

        JButton btnCreateGuest = new JButton("Create");
        btnCreateGuest.setBounds(277, 282, 89, 23);
        guestsPanel.add(btnCreateGuest);

        JButton btnEditGuest = new JButton("Edit");
        btnEditGuest.setBounds(376, 282, 89, 23);
        guestsPanel.add(btnEditGuest);

        JButton btnDeleteGuest = new JButton("Delete");
        btnDeleteGuest.setBounds(475, 282, 89, 23);
        guestsPanel.add(btnDeleteGuest);

        JPanel roomsPanel = new JPanel();
        tabbedPane.addTab("Rooms", null, roomsPanel, null);
        roomsPanel.setLayout(null);

        JList listRooms = new JList();
        listRooms.setVisibleRowCount(200);
        listRooms.setBounds(10, 11, 247, 294);
        roomsPanel.add(listRooms);

        JTextPane textPaneRoomInformation = new JTextPane();
        textPaneRoomInformation.setBounds(267, 29, 332, 245);
        roomsPanel.add(textPaneRoomInformation);

        JLabel labelRoomInformation = new JLabel("Room Information");
        labelRoomInformation.setBounds(267, 12, 160, 14);
        roomsPanel.add(labelRoomInformation);

        JButton btnCreateRoom = new JButton("Create");
        btnCreateRoom.setBounds(277, 282, 89, 23);
        roomsPanel.add(btnCreateRoom);

        JButton btnEditRoom = new JButton("Edit");
        btnEditRoom.setBounds(376, 282, 89, 23);
        roomsPanel.add(btnEditRoom);

        JButton btnDeleteRoom = new JButton("Delete");
        btnDeleteRoom.setBounds(475, 282, 89, 23);
        roomsPanel.add(btnDeleteRoom);
    }
}
/*
public class roomBooking extends JInternalFrame {
    private JTextField loggedInUserInformation;
    public DatePicker fromDatePicker;
    public DatePicker toDatePicker;

    public roomBooking() {
        setBounds(100, 100, 660, 430);
        setLayout(null);

        JButton btnRoomBooking = new JButton("Room Booking");
        btnRoomBooking.setEnabled(false);
        btnRoomBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRoomBooking.setBounds(10, 11, 120, 23);
        add(btnRoomBooking);

        JButton btnFacilitiesBooking = new JButton("Facilities Booking");
        btnFacilitiesBooking.setBounds(140, 11, 120, 23);
        add(btnFacilitiesBooking);

        loggedInUserInformation = new JTextField();
        loggedInUserInformation.setBounds(332, 12, 302, 20);
        add(loggedInUserInformation);
        loggedInUserInformation.setColumns(10);

        JLabel lblLoggedIn = new JLabel("Logged In:");
        lblLoggedIn.setBounds(270, 15, 52, 14);
        add(lblLoggedIn);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(567, 32, 67, 23);
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

        JPanel guestsPanel = new JPanel();
        tabbedPane.addTab("Guests", null, guestsPanel, null);
        guestsPanel.setLayout(null);

        JList listGuests = new JList();
        listGuests.setVisibleRowCount(200);
        listGuests.setBounds(10, 11, 247, 294);
        guestsPanel.add(listGuests);

        JTextPane textPaneGuestInformation = new JTextPane();
        textPaneGuestInformation.setBounds(267, 29, 332, 245);
        guestsPanel.add(textPaneGuestInformation);

        JLabel labelGuestInformation = new JLabel("Guest Information");
        labelGuestInformation.setBounds(267, 12, 160, 14);
        guestsPanel.add(labelGuestInformation);

        JButton btnCreateGuest = new JButton("Create");
        btnCreateGuest.setBounds(277, 282, 89, 23);
        guestsPanel.add(btnCreateGuest);

        JButton btnEditGuest = new JButton("Edit");
        btnEditGuest.setBounds(376, 282, 89, 23);
        guestsPanel.add(btnEditGuest);

        JButton btnDeleteGuest = new JButton("Delete");
        btnDeleteGuest.setBounds(475, 282, 89, 23);
        guestsPanel.add(btnDeleteGuest);

        JPanel roomsPanel = new JPanel();
        tabbedPane.addTab("Rooms", null, roomsPanel, null);
        roomsPanel.setLayout(null);

        JList listRooms = new JList();
        listRooms.setVisibleRowCount(200);
        listRooms.setBounds(10, 11, 247, 294);
        roomsPanel.add(listRooms);

        JTextPane textPaneRoomInformation = new JTextPane();
        textPaneRoomInformation.setBounds(267, 29, 332, 245);
        roomsPanel.add(textPaneRoomInformation);

        JLabel labelRoomInformation = new JLabel("Room Information");
        labelRoomInformation.setBounds(267, 12, 160, 14);
        roomsPanel.add(labelRoomInformation);

        JButton btnCreateRoom = new JButton("Create");
        btnCreateRoom.setBounds(277, 282, 89, 23);
        roomsPanel.add(btnCreateRoom);

        JButton btnEditRoom = new JButton("Edit");
        btnEditRoom.setBounds(376, 282, 89, 23);
        roomsPanel.add(btnEditRoom);

        JButton btnDeleteRoom = new JButton("Delete");
        btnDeleteRoom.setBounds(475, 282, 89, 23);
        roomsPanel.add(btnDeleteRoom);

    }
}*/