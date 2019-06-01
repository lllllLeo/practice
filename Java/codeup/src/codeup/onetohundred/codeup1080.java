package codeup.onetohundred;

import java.util.Scanner;

public class codeup1080 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int a = 1;
        int temp = 0;
        while (true) {
            temp = temp + a;
            if (temp >= data) {
                System.out.println(a);
                return;
            }
            a++;
        }
    }
}