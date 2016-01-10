package guiLayer;

import controlLayer.GUI.startupController;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class startUpFrame extends JPanel {
    private static JTextField employeeName;
    private static JTextField employeeID;
    private controlLayer.GUI.startupController startupController = new startupController();

    public startUpFrame(final JFrame frame) throws SQLException {
        setLayout(null);
        setBounds(100, 100, 660, 430);
        setVisible(true);

        employeeName = new JTextField();
        employeeName.setText(startupController.getLoggedInUserName());
        employeeName.setBounds(428, 11, 193, 20);
        employeeName.setEnabled(false);
        add(employeeName);
        employeeName.setColumns(10);

        JLabel lblNewLabel = new JLabel("Employee / Guest:");
        lblNewLabel.setBounds(330, 14, 88, 14);
        add(lblNewLabel);

        // Show the employee / guest ID - should really be loaded from the database, but it's hardcoded for now..
        JLabel lblEmployeeGuest = new JLabel("Employee / Guest ID:");
        lblEmployeeGuest.setBounds(316, 45, 102, 14);
        add(lblEmployeeGuest);

        employeeID = new JTextField();
        employeeID.setText(startupController.getLoggedInUserID());
        employeeID.setColumns(10);
        employeeID.setBounds(428, 42, 193, 20);
        employeeID.setEnabled(false);
        add(employeeID);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Error: logout not yet supported");
            }
        });
        btnLogout.setBounds(532, 74, 89, 23);
        add(btnLogout);

        JButton btnRoomBooking = new JButton("Room Booking");
        btnRoomBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Bookings Bookings = new Bookings(frame);
                frame.setContentPane(Bookings);

            }
        });
        btnRoomBooking.setBounds(10, 216, 300, 164);
        add(btnRoomBooking);

        JButton btnFacilitiesBooking = new JButton("Facilities Booking");
        btnFacilitiesBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                facilitiesBooking facilitiesBooking = new facilitiesBooking(frame);
                frame.setContentPane(facilitiesBooking);
            }
        });
        btnFacilitiesBooking.setBounds(330, 216, 300, 164);
        add(btnFacilitiesBooking);
    }
}
