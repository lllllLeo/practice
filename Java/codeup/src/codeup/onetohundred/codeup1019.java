package codeup.onetohundred;

import java.util.Scanner;

public class codeup1019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yyyymmdd = sc.nextLine();
        String [] arg = yyyymmdd.split("\\.");
        int year = Integer.parseInt(arg[0]);
        int month = Integer.parseInt(arg[1]);
        int date = Integer.parseInt(arg[2]);
        System.out.printf("%04d.%02d.%02d", year, month, date);
    }
}
