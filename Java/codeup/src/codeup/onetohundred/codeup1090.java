package codeup.onetohundred;

import java.util.Scanner;

public class codeup1090 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int r = Integer.parseInt(arg[1]);
        int n = Integer.parseInt(arg[2]);
        for (int i = 0; i < n; i++) { // n -1
            a *= r;
        }
        System.out.println(a/r);    // r 지워도 됨
    }
}
