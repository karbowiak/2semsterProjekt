import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import guiLayer.roomBooking;

public class main {
    private static JPanel startupFrame;
    private static JTextField employeeName;
    private static JTextField employeeID;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // Setup the window decorator
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        // Load the UI
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final JFrame frame = new JFrame();
                    frame.setTitle("Morocco Holiday Center");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(100, 100, 660, 430);
                    frame.setVisible(true);

                    startupFrame = new JPanel();
                    startupFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
                    frame.setContentPane(startupFrame);
                    startupFrame.setLayout(null);

                    employeeName = new JTextField();
                    employeeName.setBounds(428, 11, 193, 20);
                    startupFrame.add(employeeName);
                    employeeName.setColumns(10);

                    JLabel lblNewLabel = new JLabel("Employee / Guest:");
                    lblNewLabel.setBounds(330, 14, 88, 14);
                    startupFrame.add(lblNewLabel);

                    JLabel lblEmployeeGuest = new JLabel("Employee / Guest ID:");
                    lblEmployeeGuest.setBounds(316, 45, 102, 14);
                    startupFrame.add(lblEmployeeGuest);

                    employeeID = new JTextField();
                    employeeID.setColumns(10);
                    employeeID.setBounds(428, 42, 193, 20);
                    startupFrame.add(employeeID);

                    JButton btnLogout = new JButton("Logout");
                    btnLogout.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(frame, "Error: logout not yet supported");
                        }
                    });
                    btnLogout.setBounds(532, 74, 89, 23);
                    startupFrame.add(btnLogout);

                    JButton btnRoomBooking = new JButton("Room Booking");
                    btnRoomBooking.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            startupFrame.setVisible(false);
                            roomBooking roomBooking = new roomBooking();
                            frame.setContentPane(roomBooking);

                        }
                    });
                    btnRoomBooking.setBounds(10, 216, 300, 164);
                    startupFrame.add(btnRoomBooking);

                    JButton btnFacilitiesBooking = new JButton("Facilities Booking");
                    btnFacilitiesBooking.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            startupFrame.setVisible(false);
                        }
                    });
                    btnFacilitiesBooking.setBounds(330, 216, 300, 164);
                    startupFrame.add(btnFacilitiesBooking);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}