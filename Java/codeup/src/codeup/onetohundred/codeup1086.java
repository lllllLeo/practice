package codeup.onetohundred;

import java.util.Scanner;

public class codeup1086 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int w = Integer.parseInt(arg[0]);
        int h = Integer.parseInt(arg[1]);
        float b = Integer.parseInt(arg[2]);
        System.out.printf("%.2f MB", ((w*h*b)/(1024*1024*8)));
    }
}