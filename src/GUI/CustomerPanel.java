package GUI;

import ControlLayer.PersonController;
import ModelLayer.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerPanel extends JPanel {
    private JTextField txtName;
    private JTextField txtAddress;
    private JTextField txtCity;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField txtZip;
    private PersonController pCTRL;
    private JTextField txtCountry;

    /**
     * Create the panel.
     */
    public CustomerPanel() {
        pCTRL = new PersonController();
        setPreferredSize(new Dimension(680, 340));
        setLayout(null);

        JLabel label = new JLabel("Navn:");
        label.setBounds(10, 11, 56, 16);
        add(label);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(133, 11, 226, 16);
        add(txtName);

        JLabel label_1 = new JLabel("Adresse:");
        label_1.setBounds(10, 40, 56, 16);
        add(label_1);

        txtAddress = new JTextField();
        txtAddress.setColumns(10);
        txtAddress.setBounds(133, 40, 225, 16);
        add(txtAddress);

        JLabel label_2 = new JLabel("By:");
        label_2.setBounds(10, 98, 56, 16);
        add(label_2);

        txtCity = new JTextField();
        txtCity.setColumns(10);
        txtCity.setBounds(133, 98, 225, 16);
        add(txtCity);

        JLabel label_3 = new JLabel("Email:");
        label_3.setBounds(10, 127, 56, 16);
        add(label_3);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(133, 127, 225, 16);
        add(txtEmail);

        JLabel label_4 = new JLabel("Telefon:");
        label_4.setBounds(10, 156, 56, 16);
        add(label_4);

        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        txtPhone.setBounds(133, 156, 225, 16);
        add(txtPhone);

        JCheckBox checkBox = new JCheckBox("Erhvervskunde");
        checkBox.setEnabled(false);
        checkBox.setBounds(11, 237, 113, 25);
        add(checkBox);

        JLabel label_5 = new JLabel("CVR/EAN:");
        label_5.setBounds(11, 271, 65, 16);
        add(label_5);

        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBounds(134, 271, 225, 16);
        add(textField_5);

        JButton button = new JButton("Opret");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    createPerson();
                } catch (NumberFormatException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        button.setBounds(10, 298, 97, 25);
        add(button);

        JButton button_1 = new JButton("Opdater");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                updateCustomer();
            }
        });
        button_1.setBounds(119, 298, 97, 25);
        add(button_1);

        JButton button_2 = new JButton("Slet");
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteCustomer();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button_2.setBounds(335, 298, 97, 25);
        add(button_2);

        JButton button_3 = new JButton("Ryd");
        button_3.setBounds(442, 298, 97, 25);
        add(button_3);

        JButton button_4 = new JButton("S\u00F8g");
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCustomer();
            }
        });
        button_4.setBounds(228, 298, 97, 25);
        add(button_4);

        JLabel label_6 = new JLabel("Oprettelsesdato:");
        label_6.setBounds(11, 208, 113, 16);
        add(label_6);

        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBounds(134, 208, 225, 16);
        add(textField_6);

        JLabel label_7 = new JLabel("");
        label_7.setBounds(10, 307, 526, 16);
        add(label_7);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setFocusable(false);
        scrollPane.setBounds(369, 11, 301, 164);
        add(scrollPane);

        JCheckBox checkBox_1 = new JCheckBox("Forening");
        checkBox_1.setEnabled(false);
        checkBox_1.setBounds(134, 238, 113, 25);
        add(checkBox_1);

        txtZip = new JTextField();
        txtZip.setColumns(10);
        txtZip.setBounds(134, 71, 225, 16);
        add(txtZip);

        JLabel label_8 = new JLabel("Postnummer:");
        label_8.setBounds(11, 71, 56, 16);
        add(label_8);

        txtCountry = new JTextField();
        txtCountry.setColumns(10);
        txtCountry.setBounds(133, 183, 225, 16);
        add(txtCountry);

        JLabel lblLand = new JLabel("Land:");
        lblLand.setBounds(10, 183, 56, 16);
        add(lblLand);

    }

    protected void deleteCustomer() throws Exception {
        String phone = txtPhone.getText();
        pCTRL.deleteCustomer(phone);
    }

    protected void searchCustomer() {
        String phone = txtPhone.getText();
        Person p = pCTRL.findPerson(phone);
        txtName.setText(p.getName());
        txtAddress.setText(p.getAddress());
        txtCity.setText(p.getCity());
        txtPhone.setText((String) String.valueOf(p.getphoneNumber()));
        txtEmail.setText(p.getEmail());
        txtZip.setText(p.getZipCode());
        txtCountry.setText(p.getCountry());
    }

    protected void updateCustomer() {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String city = txtCity.getText();
        String zipCode = txtZip.getText();
        String country = txtCountry.getText();
        pCTRL.updatePerson(name, address, phone, email, city, zipCode, country, 1, phone);

    }

    protected void createPerson() throws NumberFormatException, Exception {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String city = txtCity.getText();
        String zipCode = txtZip.getText();
        String country = txtCountry.getText();
        pCTRL.insertNew(name, address, phone, email, city, zipCode, country);

    }
}
