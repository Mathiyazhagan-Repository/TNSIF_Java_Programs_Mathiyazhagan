package com.mathiyazhagan.assignment1.utilities;

import com.mathiyazhagan.assignment1.employees.Employee;

/**
 * Utility class for employee operations
 */
public class EmployeeUtilities {

    public static void displayEmployeeDetails(Employee emp) {
        System.out.println("Name: " + emp.getName());
        System.out.println("Employee ID: " + emp.getEmployeeId());
        System.out.println("Salary: " + emp.getSalary());
    }
}
