package codeup.onetohundred;

import java.util.Scanner;

public class codeup1077 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int temp = 0;
        while (temp != data+1) {
            System.out.println(temp);
            temp++;
        }
    }
}