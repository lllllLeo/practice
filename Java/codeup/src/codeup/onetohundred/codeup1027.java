package codeup.onetohundred;

import java.util.Scanner;

public class codeup1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ymd = sc.nextLine();
        String arg[] = ymd.split("\\.");
        int y = Integer.parseInt(arg[0]);
        int m = Integer.parseInt(arg[1]);
        int d = Integer.parseInt(arg[2]);
        System.out.printf("%02d-%02d-%04d",d,m,y);
    }
}

