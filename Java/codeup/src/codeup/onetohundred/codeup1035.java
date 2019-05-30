package codeup.onetohundred;

import java.util.Scanner;

public class codeup1035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        int num = Integer.valueOf(data,16);
        System.out.printf("%o", num);
    }
}
