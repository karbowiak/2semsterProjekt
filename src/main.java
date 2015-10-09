import GUI.CustomerPanel;
import GUI.NewOrderPanel;
import GUI.PanelItems;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        // Set the window decorator
        JFrame.setDefaultLookAndFeelDecorated(true);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        // Load the UI here
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setBounds(100, 100, 636, 355);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                    frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
                    PanelItems panelItems = new PanelItems();
                    CustomerPanel customerPanel = new CustomerPanel();
                    NewOrderPanel orderPanel = new NewOrderPanel();
                    tabbedPane.addTab("Produkter", null, panelItems, null);
                    tabbedPane.addTab("Personer", null, customerPanel, null);
                    tabbedPane.addTab("Ny ordre", null, orderPanel, null);
                    frame.setVisible(true);
                    frame.pack();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}