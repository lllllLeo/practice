package codeup.onetohundred;

import java.util.Scanner;

public class codeup1085 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int h = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        int c = Integer.parseInt(arg[2]);
        float s = Integer.parseInt(arg[3]);
        System.out.printf("%.1f MB", ((h*b*c*s)/8388608));
    }
}