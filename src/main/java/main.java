import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.util.Map;

import guiLayer.startUpFrame;

import tools.QuickHash;
import tools.databaseQuery;

public class main {
    private static JPanel startupFrame;

    // Start up everything
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {
        // Setup the window decorator
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        // Load the UI
        EventQueue.invokeLater(new Runnable() {
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