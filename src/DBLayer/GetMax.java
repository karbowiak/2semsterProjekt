package DBLayer;

import java.sql.*;

public class GetMax {

    /**
     * Creates a new instance of GetMax
     */
    public GetMax() {
    }

    //getMax is for the primary key in the table
    public static int getMaxId(String query) {
        ResultSet results;
        int id = 0;
        try {
            Statement stmt = DbConnection.getInstance().getDBcon().createStatement();
            results = stmt.executeQuery(query);
            if (results.next()) {
                id = results.getInt(1) + 1;
            }
        }//slut try
        catch (Exception e) {
            System.out.println("Query exception: Error in reading maxid" + e);
        }
        return id;
    }
}
