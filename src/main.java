import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // Setup the window decorator
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        // Load the UI
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setBounds(100, 100, 640, 350);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}