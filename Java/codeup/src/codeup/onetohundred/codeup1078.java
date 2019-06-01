package codeup.onetohundred;

import java.util.Scanner;

public class codeup1078 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int temp = 0;
        for (int i = 1; i < data + 1; i++) {
            if (i%2 == 0){temp = temp + i;}
        }
        System.out.println(temp);
    }
}