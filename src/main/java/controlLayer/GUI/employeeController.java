package controlLayer.GUI;
import modelLayer.Employee;
import modelLayer.Person;
import modelLayer.roomBookingGuests;
import sun.awt.image.ImageWatched;
import tools.QuickHash;
import tools.databaseQuery;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class employeeController {
    Person person = new Person();
    Employee employee = new Employee();

    public DefaultListModel getAllEmployeesListModel() {
        ArrayList<LinkedHashMap> allEmployees = employee.getAllEmployees();
        DefaultListModel employeeList = new DefaultListModel<String>();

        if(allEmployees != null) {
            for(LinkedHashMap map : allEmployees) {
                StringBuilder string = new StringBuilder();
                for(Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if (pair.getKey().equals("personFirstName"))
                        string.append("Name: " + pair.getValue() + " ");

                    if (pair.getKey().equals("personLastName"))
                        string.append("Last Name: " + pair.getValue() + " | ");

                    if (pair.getKey().equals("personPassportInformation"))
                        string.append("Passport: " + pair.getValue() + " | ");

                    if(pair.getKey().equals("employeeID"))
                        string.append("EmployeeID : " + pair.getValue() + " | ");

                    if(pair.getKey().equals("function"))
                        string.append("Function: " + pair.getValue() + " | ");
                }
            }
        }
        return employeeList;
    }

    public ArrayList<LinkedHashMap> getAllEmployeesHashMap() {
        return employee.getAllEmployees();
    }

    public Object findEmployee(int employeeID) {
        ArrayList<LinkedHashMap> allEmployees = employee.getAllEmployees();
        if(allEmployees != null) {
            for(LinkedHashMap map : allEmployees) {
                for(Object element : map.entrySet()) {
                    Map.Entry pair = (Map.Entry) element;
                    if(pair.getKey().equals("employeeID"))
                        return element;
                }
            }
        }
        return null;
    }

    public void addEmployee(String personFirstName, String personLastName, String personAddress, String personPassportInformation, String personPhoneNumber, String personEMail, String personBirthDate, String personFromCountry, String personFunction) {
        person.insertUpdatePerson(0, personFirstName, personLastName, personAddress, personPassportInformation, personPhoneNumber, personEMail, personBirthDate, personFromCountry, 2, personFunction);
    }

    public void updateEmployee(int employeeID, String personFirstName, String personLastName, String personAddress, String personPassportInformation, String personPhoneNumber, String personEMail, String personBirthDate, String personFromCountry, int personType, String personFunction) {
        person.insertUpdatePerson(employeeID, personFirstName, personLastName, personAddress, personPassportInformation, personPhoneNumber, personEMail, personBirthDate, personFromCountry, personType, personFunction);
    }

    public void deleteEmployee(int employeeID) {
        person.deletePerson(employeeID);
    }
}
