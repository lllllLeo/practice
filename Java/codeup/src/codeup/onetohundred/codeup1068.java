package codeup.onetohundred;

import java.util.Scanner;

public class codeup1068 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data>=90 && 100 >= data) {
            System.out.println("A");
        } else if (data>=80 && 90 > data) {
            System.out.println("B");
        } else if (data>=40 && 70 > data) {
            System.out.println("C");
        } else if (data>=0 && 40 > data) {
            System.out.println("D");
        }
    }
}
