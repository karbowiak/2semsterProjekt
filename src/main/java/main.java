import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import guiLayer.facilitiesBooking;
import guiLayer.roomBooking;
import guiLayer.startUpFrame;

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

                    startUpFrame startUpFrame = new startUpFrame(frame);
                    frame.setContentPane(startUpFrame);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}