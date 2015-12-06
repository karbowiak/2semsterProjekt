package modelLayer;

import tools.databaseQuery;
import java.util.Date;

public class Person {
    databaseQuery db = new databaseQuery();

    private int personID;
    private String personName; // fullName
    private String personAddress; // The address of the person
    private String personPassportInformation; // The passport information of the person, if not a guest its null
    private String personPhoneNumber; // The persons phone number
    private String personEMail; // The persons email address
    private Date personBirthDate; // The date the person was born
    private String personFromCountry; // The country of origin for the person
    private int personType; // 1: Guest 2: Employee 3: Boss
    private String personFunction; // if Employee or Boss, describe what type of function the person serves, if guest it's null
}
