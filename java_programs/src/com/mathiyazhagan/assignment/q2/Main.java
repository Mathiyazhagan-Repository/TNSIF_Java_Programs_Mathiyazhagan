package com.mathiyazhagan.assignment.q2;
class Student {
    Student() {
        System.out.println("Student object is created");
    }
}
 class Commission {
    String name, address, phone;
    double salesAmount;

    void acceptDetails(String name, String address, String phone, double salesAmount) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salesAmount = salesAmount;
    }

    void calculateCommission() {
        double commission;
        if (salesAmount >= 100000) {
            commission = salesAmount * 0.10;
        } else if (salesAmount >= 50000) {
            commission = salesAmount * 0.05;
        } else if (salesAmount >= 30000) {
            commission = salesAmount * 0.03;
        } else {
            commission = 0;
        }
        System.out.println("Commission: ₹" + commission);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        Commission c = new Commission();
        c.acceptDetails("Raj", "Chennai", "9876543210", 85000);
        c.calculateCommission();
    }
}
