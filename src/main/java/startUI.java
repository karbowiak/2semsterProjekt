import guiLayer.startUpFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class startUI extends Thread {
    private static JPanel startupFrame;

    public void run() {
        try {
            startUI();
        } catch (ClassNotFoundException e) {
            System.out.println("An error occured, oh shit.");
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("An error occured, oh shit.");
        } catch (InstantiationException e) {
            System.out.println("An error occured, oh shit.");
        } catch (IllegalAccessException e) {
            System.out.println("An error occured, oh shit.");
        } catch (SQLException e) {
            System.out.println("An error occured, oh shit.");
        }
    }
    // Start up everything
    public static void startUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {
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