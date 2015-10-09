package GUI;

import ControlLayer.OrderController;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewOrderPanel extends JPanel {
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField txtID;
    private JTextField txtAmount;
    private JTextField txtPhone;
    private OrderController oCTRL;

    /**
     * Create the panel.
     */
    public NewOrderPanel() {
        oCTRL = new OrderController();
        setPreferredSize(new Dimension(680, 340));
        setLayout(null);

        JLabel label = new JLabel("Samlet pris i DKK:");
        label.setBounds(368, 237, 112, 16);
        add(label);

        textField_5 = new JTextField();
        textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(477, 237, 126, 16);
        add(textField_5);

        JButton button = new JButton("Afslut ordre");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                endOrder();
            }
        });
        button.setBounds(245, 231, 113, 25);
        add(button);

        JButton button_1 = new JButton("Ryd");
        button_1.setBounds(20, 231, 97, 25);
        add(button_1);

        JLabel label_1 = new JLabel("");
        label_1.setBounds(10, 264, 368, 16);
        add(label_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(245, 11, 358, 217);
        add(scrollPane);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(10, 128, 225, 101);
        add(panel);

        JButton button_2 = new JButton("Slet vare");
        button_2.setBounds(117, 68, 97, 23);
        panel.add(button_2);

        JButton button_3 = new JButton("Tilføj vare");
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addItem();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button_3.setBounds(10, 67, 97, 25);
        panel.add(button_3);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(62, 11, 152, 16);
        panel.add(txtID);

        txtAmount = new JTextField();
        txtAmount.setColumns(10);
        txtAmount.setBounds(62, 40, 152, 16);
        panel.add(txtAmount);

        JLabel label_2 = new JLabel("Antal:");
        label_2.setBounds(10, 40, 56, 16);
        panel.add(label_2);

        JLabel label_3 = new JLabel("Vare ID:");
        label_3.setBounds(10, 11, 56, 16);
        panel.add(label_3);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(10, 11, 225, 101);
        add(panel_1);

        JCheckBox checkBox = new JCheckBox("Erhvervskunde");
        checkBox.setEnabled(false);
        checkBox.setBounds(62, 34, 123, 23);
        panel_1.add(checkBox);

        txtPhone = new JTextField();
        txtPhone.setText("Telefonnummer/CVR");
        txtPhone.setColumns(10);
        txtPhone.setBounds(62, 11, 152, 16);
        panel_1.add(txtPhone);

        JLabel label_4 = new JLabel("Kunde:");
        label_4.setBounds(10, 11, 56, 16);
        panel_1.add(label_4);


    }

    protected void endOrder() {
        oCTRL.endOrder(txtPhone.getText());

    }

    protected void addItem() throws NumberFormatException, Exception {
        oCTRL.insertNewPartOrder(Integer.parseInt(txtID.getText()), Integer.parseInt(txtAmount.getText()));

    }
}
