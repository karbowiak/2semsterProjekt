package DBLayer;

import ModelLayer.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDB {

    private Connection con;

    public PersonDB() {
        con = DbConnection.getInstance().getDBcon();
    }

    public void insertPerson(Person newPers) throws Exception {
        String query = "INSERT INTO customer(name, address, phoneNumber, zipCode, city) "
                + "VALUES(?, ?, ?, ?, ?)";
        try { // insert new person
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newPers.getName());
            pstmt.setString(2, newPers.getAddress());
            pstmt.setInt(3, Integer.parseInt(newPers.getphoneNumber()));
            pstmt.setString(4, newPers.getZipCode());
            pstmt.setString(5, newPers.getCity());
            pstmt.setQueryTimeout(5);
            pstmt.executeUpdate();
            pstmt.close();
        }//end try
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Person findPerson(String phoneNumber) {
        String wClause = "  phoneNumber = ?";
        return singleWhere(wClause, phoneNumber);
    }

    private Person singleWhere(String wClause, String phoneNumber) {
        ResultSet results;
        Person pers = new Person();

        String query = buildQuery(wClause);
        System.out.println(query);
        try { // read the product from the database
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, phoneNumber);
            pstmt.setQueryTimeout(5);
            results = pstmt.executeQuery();
            if (results.next()) {
                pers = build(results);
                //assocaition is to be build
                pstmt.close();
            } else { //no employee was found
                pers = null;
            }
        }//end try
        catch (Exception e) {
            System.out.println("Query exception: " + e);
        }
        return pers;
    }

    //method to build the query
    private String buildQuery(String wClause) {
        String query = "SELECT customerID, name, address, phoneNumber, zipCode, city FROM customer";
        if (wClause.length() > 0)
            query = query + " WHERE " + wClause;

        return query;
    }

    private Person build(ResultSet results) {
        Person pers = new Person();
        try { // the columns from the table product  are used
            pers.setName(results.getString("name"));
            pers.setAddress(results.getString("address"));
            pers.setphoneNumber(results.getString("phoneNumber"));
            pers.setZipCode(results.getString("zipCode"));
            pers.setCity(results.getString("city"));
            pers.setId(results.getInt("customerID"));
        } catch (Exception e) {
            System.out.println("error in building the person object");
        }
        return pers;
    }

    public ArrayList<Person> getAllPersons(boolean b) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updatePerson(Person pers, String oldPhone) {
        Person newPers = pers;
        String query = "UPDATE customer SET name = ?, address = ?, phoneNumber = ?, zipCode = ?, City = ?"
                + " WHERE phoneNumber = ?";
        System.out.println("Update query:" + query);
        try { // update product
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, newPers.getName());
            pstmt.setString(2, newPers.getAddress());
            pstmt.setString(3, newPers.getphoneNumber());
            pstmt.setString(4, newPers.getZipCode());
            pstmt.setString(5, newPers.getCity());
            pstmt.setString(6, oldPhone);

            pstmt.setQueryTimeout(5);
            pstmt.executeUpdate();

            pstmt.close();
        } catch (Exception ex) {
            System.out.println("Update exception in product db: " + ex);
        }
    }

    public void deletePerson(String phoneNumber) {
        Person tempP = findPerson(phoneNumber);
        tempP.setIsActive(0);
        updatePerson(tempP, phoneNumber);
    }
}