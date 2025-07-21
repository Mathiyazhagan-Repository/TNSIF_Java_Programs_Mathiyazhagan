package com.mathiyazhagan.assignment.ScoretrackerApplication;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentScoreTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📚 Welcome to the Student Score Tracker!");
        System.out.println("Please enter the number of test scores:");
        System.out.println("Then enter each score one by one:");

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        ArrayList<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scoreList.add(scores[i]);
        }

        System.out.println("✅ Scores you entered:");
        for (int score : scoreList) {
            System.out.println(score);
        }

        sc.close();
    }
}
