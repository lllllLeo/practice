package codeup.onetohundred;

import java.util.Scanner;

public class codeup1081 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int n = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.println(i+" "+j);
            }
        }

    }
}