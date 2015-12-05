package guiLayer;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class startUpFrame extends JPanel {
    private static JTextField employeeName;
    private static JTextField employeeID;

    public startUpFrame(final JFrame frame) {
        setLayout(null);
        setBounds(100, 100, 660, 430);
        setVisible(true);

        employeeName = new JTextField();
        employeeName.setBounds(428, 11, 193, 20);
        add(employeeName);
        employeeName.setColumns(10);

        JLabel lblNewLabel = new JLabel("Employee / Guest:");
        lblNewLabel.setBounds(330, 14, 88, 14);
        add(lblNewLabel);

        JLabel lblEmployeeGuest = new JLabel("Employee / Guest ID:");
        lblEmployeeGuest.setBounds(316, 45, 102, 14);
        add(lblEmployeeGuest);

        employeeID = new JTextField();
        employeeID.setColumns(10);
        employeeID.setBounds(428, 42, 193, 20);
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
                roomBooking roomBooking = new roomBooking(frame);
                frame.setContentPane(roomBooking);

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
