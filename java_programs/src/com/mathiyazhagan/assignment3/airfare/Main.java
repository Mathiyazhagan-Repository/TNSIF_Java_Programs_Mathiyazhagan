package com.mathiyazhagan.assignment3.airfare;
import java.util.Scanner;

abstract class Airline {
    protected int hours;
    protected double costPerHour;

    public Airline(int hours, double costPerHour) {
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public abstract double calculateCost();
}

class AirIndia extends Airline {
    public AirIndia(int hours, double costPerHour) {
        super(hours, costPerHour);
    }

    public double calculateCost() {
        return hours * costPerHour;
    }
}

class KingFisher extends Airline {
    public KingFisher(int hours, double costPerHour) {
        super(hours, costPerHour);
    }

    public double calculateCost() {
        return hours * costPerHour * 4;
    }
}

class Indigo extends Airline {
    public Indigo(int hours, double costPerHour) {
        super(hours, costPerHour);
    }

    public double calculateCost() {
        return hours * costPerHour * 8;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Airline Fare Calculator!");
        System.out.println("Please enter the name of the airline (AirIndia, KingFisher, or Indigo):");
        System.out.println("Then enter the number of hours traveled:");
        System.out.println("Finally, enter the cost per hour:");

        String airlineName = sc.next();
        int hours = sc.nextInt();
        double costPerHour = sc.nextDouble();

        Airline airline;

        if (airlineName.equalsIgnoreCase("AirIndia")) {
            airline = new AirIndia(hours, costPerHour);
        } else if (airlineName.equalsIgnoreCase("KingFisher")) {
            airline = new KingFisher(hours, costPerHour);
        } else if (airlineName.equalsIgnoreCase("Indigo")) {
            airline = new Indigo(hours, costPerHour);
        } else {
            System.out.println("Invalid airline name");
            System.out.println("I can't understand");
            sc.close();
            return;
        }

        double total = airline.calculateCost();
        System.out.printf("Total fare: %.2f\n", total);

        sc.close();
    }
}