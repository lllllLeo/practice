package codeup.onetohundred;

import java.util.Scanner;

public class codeup1075 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char data = sc.next().charAt(0);
        int a = 97;
        int asciiData = (int)data;
        while (a != asciiData+1) {
            System.out.print((char)a+" ");
            a++;
        }
    }
}