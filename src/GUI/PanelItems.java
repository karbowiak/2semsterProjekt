package GUI;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;

import ControlLayer.ProductController;
import ModelLayer.Product;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelItems extends JPanel {
    private JTextField txtName;
    private JTextField txtPurchasePrice;
    private JTextField txtSalesPrice;
    private JTextField txtID;
    private JTextField txtRentPrice;
    private JTextField txtCountryOfOrigin;
    private JTextField txtMinStock;
    private JTextField txtType;
    private JTextField txtSupplier_ID;
    private ProductController pCTRL;
    private int oldId;

    /**
     * Create the panel.
     */
    public PanelItems() {
        oldId = 0;
        pCTRL = new ProductController();
        setPreferredSize(new Dimension(680, 340));
        setLayout(null);

        JLabel lblNavn = new JLabel("Navn:");
        lblNavn.setBounds(10, 11, 81, 16);
        add(lblNavn);

        txtName = new JTextField();
        txtName.setColumns(10);
        txtName.setBounds(101, 11, 226, 16);
        add(txtName);

        JLabel lblIndkbspris_1 = new JLabel("Indk\u00F8bspris:");
        lblIndkbspris_1.setBounds(10, 40, 81, 16);
        add(lblIndkbspris_1);

        txtPurchasePrice = new JTextField();
        txtPurchasePrice.setColumns(10);
        txtPurchasePrice.setBounds(101, 40, 226, 16);
        add(txtPurchasePrice);

        JLabel lblSalgspris = new JLabel("Salgspris:");
        lblSalgspris.setBounds(10, 69, 81, 16);
        add(lblSalgspris);

        txtSalesPrice = new JTextField();
        txtSalesPrice.setColumns(10);
        txtSalesPrice.setBounds(101, 69, 226, 16);
        add(txtSalesPrice);

        JButton btnCreate = new JButton("Opret");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createProduct();
                } catch (Exception e1) {
                    e1.printStackTrace();

                }
            }


        });
        btnCreate.setBounds(10, 142, 97, 25);
        add(btnCreate);

        JButton btnUpdate = new JButton("Opdater");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateProduct();

            }


        });
        btnUpdate.setEnabled(false);
        btnUpdate.setBounds(119, 142, 97, 25);
        add(btnUpdate);

        JButton btnDelete = new JButton("Slet");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    delete();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        btnDelete.setBounds(228, 142, 97, 25);
        add(btnDelete);

        JButton btnClear = new JButton("Ryd");
        btnClear.setBounds(337, 142, 97, 25);
        add(btnClear);

        JLabel label_3 = new JLabel("");
        label_3.setBounds(10, 182, 526, 16);
        add(label_3);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(10, 96, 424, 31);
        add(panel);

        JLabel label_4 = new JLabel("ID:");
        label_4.setBounds(10, 8, 56, 16);
        panel.add(label_4);

        txtID = new JTextField();
        txtID.setColumns(10);
        txtID.setBounds(92, 8, 226, 16);
        panel.add(txtID);

        JButton btnSearch = new JButton("S\u00F8g");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
        btnSearch.setBounds(328, 5, 82, 22);
        panel.add(btnSearch);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 209, 424, 123);
        add(scrollPane);

        txtRentPrice = new JTextField();
        txtRentPrice.setColumns(10);
        txtRentPrice.setBounds(535, 11, 135, 16);
        add(txtRentPrice);

        txtCountryOfOrigin = new JTextField();
        txtCountryOfOrigin.setColumns(10);
        txtCountryOfOrigin.setBounds(535, 40, 135, 16);
        add(txtCountryOfOrigin);

        JLabel lblIndkbspris = new JLabel("Oprindelse:");
        lblIndkbspris.setBounds(444, 40, 81, 16);
        add(lblIndkbspris);

        JLabel lblPrisForLeje = new JLabel("Pris for leje:");
        lblPrisForLeje.setBounds(444, 11, 81, 16);
        add(lblPrisForLeje);

        txtMinStock = new JTextField();
        txtMinStock.setColumns(10);
        txtMinStock.setBounds(535, 98, 135, 16);
        add(txtMinStock);

        JLabel lblMin = new JLabel("Min lager:");
        lblMin.setBounds(444, 98, 81, 16);
        add(lblMin);

        JLabel lblLand = new JLabel("Type:");
        lblLand.setBounds(444, 69, 81, 16);
        add(lblLand);

        txtType = new JTextField();
        txtType.setColumns(10);
        txtType.setBounds(535, 69, 135, 16);
        add(txtType);

        JLabel lblLeverandrId = new JLabel("Leverand\u00F8r ID:");
        lblLeverandrId.setBounds(444, 142, 81, 16);
        add(lblLeverandrId);

        txtSupplier_ID = new JTextField();
        txtSupplier_ID.setColumns(10);
        txtSupplier_ID.setBounds(535, 144, 135, 16);
        add(txtSupplier_ID);

    }

    protected void createProduct() throws Exception {
        String name = txtName.getText();
        int id = Integer.parseInt(txtID.getText());
        oldId = id;
        float purchasePrice = Float.parseFloat(txtPurchasePrice.getText());
        float salesPrice = Float.parseFloat(txtSalesPrice.getText());
        float rentPrice = Float.parseFloat(txtRentPrice.getText());
        String countryOfOrigin = txtCountryOfOrigin.getText();
        int minStock = Integer.parseInt(txtMinStock.getText());
        int type = Integer.parseInt(txtType.getText());
        int supplier_ID = Integer.parseInt(txtSupplier_ID.getText());


        pCTRL.insertNew(id, name, minStock, purchasePrice, rentPrice, salesPrice, countryOfOrigin, type, supplier_ID, 1);

    }

    protected void updateProduct() {
        String name = txtName.getText();
        int id = Integer.parseInt(txtID.getText());
        float purchasePrice = Float.parseFloat(txtPurchasePrice.getText());
        float salesPrice = Float.parseFloat(txtSalesPrice.getText());
        float rentPrice = Float.parseFloat(txtRentPrice.getText());
        String countryOfOrigin = txtCountryOfOrigin.getText();
        int minStock = Integer.parseInt(txtMinStock.getText());
        int type = Integer.parseInt(txtType.getText());
        int supplier_ID = Integer.parseInt(txtSupplier_ID.getText());

        pCTRL.updateProduct(oldId, id, name, minStock, purchasePrice, rentPrice, salesPrice, countryOfOrigin, type, supplier_ID, 1);
    }

    protected void delete() throws Exception {
        int id = Integer.parseInt(txtID.getText());
        pCTRL.deleteProduct(id);
    }

    protected void search() {
        oldId = Integer.parseInt(txtID.getText());
        int id = oldId;
        Product tempP = pCTRL.findProduct(id);
        txtPurchasePrice.setText((String) String.valueOf(tempP.getPurchasePrice()));
        txtSalesPrice.setText((String) String.valueOf(tempP.getSalesPrice()));
        txtRentPrice.setText((String) String.valueOf(tempP.getRentPrice()));
        txtCountryOfOrigin.setText(tempP.getCountryOfOrigin());
        txtMinStock.setText((String) String.valueOf(tempP.getMinStock()));
        txtType.setText((String) String.valueOf(tempP.getType()));
        txtSupplier_ID.setText((String) String.valueOf(tempP.getSupplierID()));
        txtName.setText(tempP.getName());

    }

}
