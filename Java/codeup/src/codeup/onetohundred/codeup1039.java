package codeup.onetohundred;

import java.util.Scanner;

public class codeup1039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String [] arg = data.split(" ");
        long a = Long.parseLong(arg[0]);
        long b = Long.parseLong(arg[1]);
        System.out.println((a)+(b));
    }
}
