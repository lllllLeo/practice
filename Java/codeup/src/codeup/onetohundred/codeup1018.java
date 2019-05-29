package codeup.onetohundred;

import java.util.Scanner;

public class codeup1018 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        String [] arg = time.split(":");
        int a = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        System.out.printf("%d:%d", a,b);

    }
}

