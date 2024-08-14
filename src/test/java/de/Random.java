package de;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Random {
    public static void main(String ar[]) {
        // Converting LocalDate to String
        // Example 1
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the date1 in format yyyy-mm-dd");
        String date1 = sc.nextLine();
        LocalDate d1 = LocalDate.parse(date1);
        System.out.println("Date in string :  " + d1);

        System.out.println("Enter the date2 in format yyyy-mm-dd");
        String date2 = sc.nextLine();
        LocalDate d2 = LocalDate.parse(date2);
        System.out.println("Date in string :  " + d2);

        long daysBetween = DAYS.between(d1, d2);
        System.out.println("Days between: " + daysBetween);
    }
}
