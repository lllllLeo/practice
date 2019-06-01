package codeup.onetohundred;

import java.util.Scanner;

public class codeup1083 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        for (int i = 1; i < data+1; i++) {
            if (i == 3 || i == 6 || i == 9) {
                System.out.println("X");
                continue;
            }
            System.out.println(i);
        }
    }
}