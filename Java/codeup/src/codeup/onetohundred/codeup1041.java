package codeup.onetohundred;

import java.util.Scanner;

public class codeup1041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char data = sc.next().charAt(0);
        int num = (int)data+1;
        data = (char)num;
        System.out.println(data);
    }
}
