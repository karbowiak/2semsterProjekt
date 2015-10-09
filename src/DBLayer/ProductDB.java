/**
 *
 */
package DBLayer;

import ModelLayer.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDB {
    private Connection con;

    /**
     * Creates a new instance of ProductDB
     */
    public ProductDB() {
        con = DbConnection.getInstance().getDBcon();
    }

    public void insertProduct(Product newProd) throws Exception {
        String query = "INSERT INTO product(name, purchasePrice, salePrice, rentPrice, originCountry, minStock, supplierID, type)  "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try { // insert new product
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newProd.getName());
            pstmt.setFloat(2, newProd.getPurchasePrice());
            pstmt.setFloat(3, newProd.getSalesPrice());
            pstmt.setFloat(4, newProd.getRentPrice());
            pstmt.setString(5, newProd.getCountryOfOrigin());
            pstmt.setInt(6, newProd.getMinStock());
            pstmt.setInt(7, newProd.getSupplierID());
            pstmt.setInt(8, newProd.getType());
            pstmt.setQueryTimeout(5);
            pstmt.executeUpdate();
            pstmt.close();
        }//end try
        catch (SQLException ex) {
            System.out.println("Produkt ikke oprettet");
            throw new Exception("Product is not inserted correct");
        }
    }

    public Product findProduct(int productID) {
        String wClause = "  productID = ? ";
        return singleWhere(wClause, productID);
    }

    public void updateProduct(Product prod, int oldID) {
        Product newProd = prod;
        String query = "UPDATE product SET productID = ?, name = ?, purchasePrice = ?, salePrice = ?, rentPrice = ?, originCountry = ?, minStock = ?, supplierID = ?, type = ?"
                + " WHERE productID = ?";
        System.out.println("Update query:" + query);
        try { // update product
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newProd.getName());
            pstmt.setFloat(2, newProd.getPurchasePrice());
            pstmt.setFloat(3, newProd.getSalesPrice());
            pstmt.setFloat(4, newProd.getRentPrice());
            pstmt.setString(5, newProd.getCountryOfOrigin());
            pstmt.setInt(6, newProd.getMinStock());
            pstmt.setInt(7, newProd.getSupplierID());
            pstmt.setInt(8, newProd.getType());
            pstmt.setInt(9, oldID);
            pstmt.setQueryTimeout(5);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception ex) {
            System.out.println("Update exception in product db: " + ex);
        }
    }

    //Singelwhere is used when we only select one product
    private Product singleWhere(String wClause, int productID) {
        ResultSet results;
        Product prod = new Product();

        String query = buildQuery(wClause);
        System.out.println(query);
        try { // read the product from the database
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, productID);
            pstmt.setQueryTimeout(5);
            results = pstmt.executeQuery();
            if (results.next()) {
                prod = buildProduct(results);
                //association is to be build
                pstmt.close();
            } else { //no product was found
                prod = null;
            }
        }//end try
        catch (Exception e) {
            System.out.println("Query exception: " + e);
        }
        return prod;
    }

    public ArrayList<Product> getAllProducts() {
        ResultSet results;
        String query = "SELECT * FROM Product";
        ArrayList<Product> allProducts = new ArrayList<Product>();
        Product prod = new Product();
        try { // read the product from the database
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setQueryTimeout(5);
            results = pstmt.executeQuery();
            while (results.next()) {
                prod = buildProduct(results);
                allProducts.add(prod);
                //association is to be build
            }
            pstmt.close();
        } catch (Exception e) {
            System.out.println("Query exception: " + e);
        }

        return allProducts;
    }

    //method to build the query
    private String buildQuery(String wClause) {
        String query = "SELECT productID, name, purchasePrice, salePrice, rentPrice, originCountry, minStock, supplierID, type FROM product";

        if (wClause.length() > 0)
            query = query + " WHERE " + wClause;

        return query;
    }

    //method to build an employee object
    private Product buildProduct(ResultSet results) {
        Product prod = new Product();
        try { // the columns from the table product  are used
            prod.setId(results.getInt("productID"));
            prod.setName(results.getString("name"));
            prod.setPurchasePrice(results.getFloat("purchasePrice"));
            prod.setSalesPrice(results.getFloat("salesPrice"));
            prod.setRentPrice(results.getFloat("rentPrice"));
            prod.setCountryOfOrigin(results.getString("originCountry"));
            prod.setMinStock(results.getInt("minStock"));
            prod.setSupplierID(results.getInt("supplierID"));
        } catch (Exception e) {
            System.out.println("error in building the product object");
        }
        return prod;
    }


}
