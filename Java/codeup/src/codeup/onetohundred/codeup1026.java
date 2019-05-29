package codeup.onetohundred;

import java.util.Scanner;

public class codeup1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        String min[] = time.split(":");
        System.out.println(min[1]);
    }
}

