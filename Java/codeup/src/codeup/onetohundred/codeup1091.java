package codeup.onetohundred;

import java.util.Scanner;

public class codeup1091 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);
        int d = Integer.parseInt(arg[2]);
        int n = Integer.parseInt(arg[3]);
        for (int i = 0; i < n - 1; i++) {
            a = a * m + d;
        }
        System.out.println(a);
    }
}
