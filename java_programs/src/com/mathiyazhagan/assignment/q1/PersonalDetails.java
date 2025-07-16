package com.mathiyazhagan.assignment.q1;

import java.util.Scanner;

public class PersonalDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your full name with initial: ");
        String name = sc.nextLine();

        System.out.print("Enter your roll number: ");
        String rollNumber = sc.nextLine();

        System.out.print("Enter your grade: ");
        String grade = sc.nextLine();

        System.out.print("Enter your percentage: ");
        String percentage = sc.nextLine();

        System.out.println("\n--- Output ---");
        System.out.println(name);
        System.out.println(rollNumber);
        System.out.println(grade);
        System.out.println(percentage);
    }
}