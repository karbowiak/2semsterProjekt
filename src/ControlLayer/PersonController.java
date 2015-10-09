package ControlLayer;

import DBLayer.DbConnection;
import DBLayer.PersonDB;
import ModelLayer.Person;

import java.util.ArrayList;

public class PersonController {
    /**
     *
     */
    public PersonController() {
        // TODO Auto-generated constructor stub
    }

    public Person findPerson(String phoneNumber) {
        PersonDB pDB = new PersonDB();
        return pDB.findPerson(phoneNumber);
    }

    public ArrayList<Person> findAllPersons() {
        PersonDB pDB = new PersonDB();
        ArrayList<Person> allPers = new ArrayList<Person>();
        allPers = pDB.getAllPersons(false);
        return allPers;
    }

    public void updatePerson(String name, String address, String phoneNumber, String email, String city, String zipCode, String country, int isActive, String oldPhone) {
        PersonDB pDB = new PersonDB();
        Person pers = new Person(name, address, phoneNumber, email, city, zipCode, country, isActive);
        pDB.updatePerson(pers, oldPhone);
    }

    public void insertNew(String name, String address, String phoneNumber, String email, String city, String zipCode, String country) throws Exception {
        Person custObj = new Person(name, address, phoneNumber, email, city, zipCode, country, 1);
        try {
            DbConnection.startTransaction();
            PersonDB pDB = new PersonDB();
            pDB.insertPerson(custObj);
            DbConnection.commitTransaction();
        } catch (Exception e) {
            DbConnection.rollbackTransaction();
            throw new Exception("Customer not inserted");
        }
    }

    public void deleteCustomer(String phoneNumber) throws Exception {
        try {
            DbConnection.startTransaction();
            PersonDB pDB = new PersonDB();
            pDB.deletePerson(phoneNumber);
            DbConnection.commitTransaction();
        } catch (Exception e) {
            DbConnection.rollbackTransaction();
            throw new Exception("Customer not deleted");
        }
    }
}