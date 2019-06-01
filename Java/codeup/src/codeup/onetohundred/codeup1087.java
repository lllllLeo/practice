package codeup.onetohundred;

import java.util.Scanner;

public class codeup1087 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int data = sc.nextInt();
        int val = 0;
        for (int i = 1; i <= data; i++) {
            val = val + i;
            if (val >= data) { break; }
        }
            System.out.println(val);
    }
}
