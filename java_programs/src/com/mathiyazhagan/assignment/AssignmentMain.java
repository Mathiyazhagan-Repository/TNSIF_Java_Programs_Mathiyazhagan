package com.mathiyazhagan.assignment;

import com.mathiyazhagan.assignment1.employees.Developer;
import com.mathiyazhagan.assignment1.employees.Manager;
import com.mathiyazhagan.assignment1.utilities.EmployeeUtilities;

/**
 * Main class to test the application
 */
public class AssignmentMain {
    public static void main(String[] args) {
        Manager mgr = new Manager("Ravi", 1001, 85000, "HR");
        Developer dev = new Developer("Anu", 2002, 75000, "Java");

        System.out.println("--- Manager Details ---");
        EmployeeUtilities.displayEmployeeDetails(mgr);
        System.out.println("Department: " + mgr.getDepartment());

        System.out.println("\n--- Developer Details ---");
        EmployeeUtilities.displayEmployeeDetails(dev);
        System.out.println("Programming Language: " + dev.getProgrammingLanguage());
    }
}
