package modelLayer;

import tools.QuickHash;
import tools.databaseQuery;

import java.sql.SQLException;
import java.util.*;

import static tools.databaseQuery.dbQuery;
import static tools.databaseQuery.dbQueryRow;
import static tools.databaseQuery.dbQueryField;
import static tools.databaseQuery.dbExecute;

public class Person {
    databaseQuery db = new databaseQuery();

    private int personID;
    private String personFirstName; // First part of a persons name (Eg: Peter John)
    private String personLastName; // Last part of a persons name (Eg: Jackson)
    private String personAddress; // The address of the person
    private String personPassportInformation; // The passport information of the person, if not a guest its null
    private String personPhoneNumber; // The persons phone number (Should probably be a json string, to store multiple numbers, eg Work: xxxx Home: xxxx
    private String personEMail; // The persons email address
    private String personBirthDate; // The date the person was born
    private String personFromCountry; // The country of origin for the person
    private int personType; // 1: Guest 2: Employee 3: Boss
    private String personFunction; // if Employee or Boss, describe what type of function the person serves, if guest it's null

    // Stuff that can be used later.. not that it has to..
    private QuickHash personTypeSpecification = new QuickHash("1", String.valueOf("Guest"), "2", String.valueOf("Employee"), "3", String.valueOf("Boss"));

    public ArrayList<LinkedHashMap> getAllPersons() {
        Map<String, String> parameters = new QuickHash();
        try {
            return dbQuery("SELECT * FROM persons", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    public LinkedHashMap getPerson(int personID) {
        Map<String, String> parameters = new QuickHash(":personID", String.valueOf(personID));
        try {
            return dbQueryRow("SELECT * FROM persons WHERE personID = :personID", parameters);
        } catch (SQLException e) {
            return null;
        }
    }

    public int insertUpdatePerson() {
        return insertUpdatePerson(0, "", "", "", "", "", "", "", "", 1, "");
    }

    public int insertUpdatePerson(int personID, String personFirstName, String personLastName, String personAddress, String personPassportInformation, String personPhoneNumber, String personEMail, String personBirthDate, String personFromCountry, int personType, String personFunction) {
        int id;
        Map<String, String> parameters = new QuickHash(":personFirstName", String.valueOf(personFirstName), ":personLastName", String.valueOf(personLastName), ":personAddress", String.valueOf(personAddress), ":personPassportInformation", String.valueOf(personPassportInformation), ":personPhoneNumber", String.valueOf(personPhoneNumber), ":personEMail", String.valueOf(personEMail), ":personBirthDate", String.valueOf(personBirthDate), ":personFromCountry", String.valueOf(personFromCountry), ":personType", String.valueOf(personType), ":personFunction", String.valueOf(personFunction));

        if(personID > 0) {
            id = personID;
        }
        else {
            try {
                String queryData = dbQueryField("SELECT personID FROM persons WHERE personFirstName = :personFirsTName AND personLastName = :personLastName AND personPassportInformation = :personPassportInformation", "personID", parameters);
                if(!Objects.equals(queryData, ""))
                    id = Integer.parseInt(queryData);
                else
                    id = 0;
            } catch (SQLException e) {
                id = 0;
            }
        }

        if(id > 0) {
            Map<String, String> updateParameters = new QuickHash(":personID", String.valueOf(id), ":personFirstName", String.valueOf(personFirstName), ":personLastName", String.valueOf(personLastName), ":personAddress", String.valueOf(personAddress), ":personPassportInformation", String.valueOf(personPassportInformation), ":personPhoneNumber", String.valueOf(personPhoneNumber), ":personEMail", String.valueOf(personEMail), ":personBirthDate", String.valueOf(personBirthDate), ":personFromCountry", String.valueOf(personFromCountry), ":personType", String.valueOf(personType), ":personFunction", String.valueOf(personFunction));
            try {
                if(!Objects.equals(personFirstName, ""))
                    dbExecute("UPDATE persons SET personFirstName = :personFirstName WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personLastName, ""))
                    dbExecute("UPDATE persons SET personLastName = :personLastName WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personAddress, ""))
                    dbExecute("UPDATE persons SET personAddress = :personAddress WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personPassportInformation, ""))
                    dbExecute("UPDATE persons SET personPassportInformation = :personPassportInformation WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personPhoneNumber, ""))
                    dbExecute("UPDATE persons SET personPhoneNumber = :personPhoneNumber WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personEMail, ""))
                    dbExecute("UPDATE persons SET personEMail = :personEMail WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personBirthDate, ""))
                    dbExecute("UPDATE persons SET personBirthDate = :personBirthDate WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personFromCountry, ""))
                    dbExecute("UPDATE persons SET personFromCountry = :personFromCountry WHERE personID = :personID", updateParameters);
                if(personType > 1)
                    dbExecute("UPDATE persons SET personType = :personType WHERE personID = :personID", updateParameters);
                if(!Objects.equals(personFunction, ""))
                    dbExecute("UPDATE persons SET personFunction = :personFunction WHERE personID = :personID", updateParameters);
            } catch (SQLException e) {
                return 0;
            }
        }
        else {
            try {
                dbExecute("INSERT INTO persons (personFirstName, personLastName, personAddress, personPassportInformation, personPhoneNumber, personEMail, personBirthDate, personFromCountry, personType, personFunction) VALUES (:personFirstName, :personLastName, :personAddress, :personPassportInformation, :personPhoneNumber, :personEMail, :personBirthDate, :personFromCountry, :personType, :personFunction)", parameters);
            } catch (SQLException e) {
                return 0;
            }
        }

        return id;
    }

    public boolean deletePerson(int personID) {
        Map<String, String> parameters = new QuickHash(":personID", String.valueOf(personID));
        try {
            dbExecute("DELETE FROM persons WHERE personID = :personID", parameters);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
