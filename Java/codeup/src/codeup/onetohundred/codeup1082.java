package codeup.onetohundred;

import java.util.Scanner;

public class codeup1082 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int r = Integer.parseInt(arg[0]);
        int g = Integer.parseInt(arg[1]);
        int b = Integer.parseInt(arg[2]);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < g; j++) {
                for (int k = 0; k < b; k++) {
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }
        System.out.println(r*g*b);
    }
}