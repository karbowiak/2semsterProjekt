package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class SupplierPanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;

    /**
     * Create the panel.
     */
    public SupplierPanel() {
        setPreferredSize(new Dimension(680, 340));
        setLayout(null);

        JLabel label = new JLabel("Navn:");
        label.setBounds(10, 11, 56, 16);
        add(label);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(133, 11, 226, 16);
        add(textField);

        JLabel label_1 = new JLabel("Adresse:");
        label_1.setBounds(10, 40, 56, 16);
        add(label_1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(133, 40, 226, 16);
        add(textField_1);

        JLabel label_2 = new JLabel("By:");
        label_2.setBounds(10, 94, 56, 16);
        add(label_2);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(133, 69, 226, 16);
        add(textField_2);

        JLabel label_3 = new JLabel("Email:");
        label_3.setBounds(10, 154, 56, 16);
        add(label_3);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(133, 127, 226, 16);
        add(textField_3);

        JLabel label_4 = new JLabel("Telefon:");
        label_4.setBounds(10, 127, 56, 16);
        add(label_4);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(133, 156, 226, 16);
        add(textField_4);

        JButton button = new JButton("S\u00F8g");
        button.setBounds(228, 234, 97, 25);
        add(button);

        JButton button_1 = new JButton("Opret");
        button_1.setBounds(10, 234, 97, 25);
        add(button_1);

        JButton button_2 = new JButton("Opdater");
        button_2.setEnabled(false);
        button_2.setBounds(119, 234, 97, 25);
        add(button_2);

        JButton button_3 = new JButton("Slet");
        button_3.setBounds(335, 234, 97, 25);
        add(button_3);

        JButton button_4 = new JButton("Ryd");
        button_4.setBounds(439, 234, 97, 25);
        add(button_4);

        JLabel label_5 = new JLabel("Postnummer:");
        label_5.setBounds(10, 67, 97, 16);
        add(label_5);

        JLabel label_6 = new JLabel("Land:");
        label_6.setBounds(10, 181, 56, 16);
        add(label_6);

        JLabel label_7 = new JLabel("Oprettelsesdato:");
        label_7.setBounds(10, 210, 113, 16);
        add(label_7);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(133, 210, 226, 16);
        add(textField_5);

        JLabel label_8 = new JLabel("");
        label_8.setBounds(10, 272, 526, 16);
        add(label_8);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(371, 11, 299, 212);
        add(scrollPane);

        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(133, 181, 226, 16);
        add(textField_6);

        textField_7 = new JTextField();
        textField_7.setColumns(10);
        textField_7.setBounds(133, 96, 226, 16);
        add(textField_7);

    }

}
