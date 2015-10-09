package GUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;


public class OrderPanel extends JPanel {

    /**
     * Create the panel.
     */
    public OrderPanel() {
        setPreferredSize(new Dimension(680, 340));
        setLayout(null);

        JButton button = new JButton("Slet ordre");
        button.setBounds(10, 199, 97, 25);
        add(button);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 36, 310, 150);
        add(scrollPane);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(341, 36, 329, 150);
        add(scrollPane_1);

        JLabel label = new JLabel("Alle ordre:");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setBounds(10, 11, 121, 14);
        add(label);

        JLabel label_1 = new JLabel("Varer p\u00E5 ordren:");
        label_1.setHorizontalAlignment(SwingConstants.LEFT);
        label_1.setBounds(341, 11, 121, 14);
        add(label_1);

    }
}
