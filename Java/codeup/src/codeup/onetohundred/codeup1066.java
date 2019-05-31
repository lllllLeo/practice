package codeup.onetohundred;

import java.util.Scanner;

public class codeup1066 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] arg = data.split(" ");
        for (int i = 0; i < arg.length; i++) {
            if (Integer.parseInt(arg[i])%2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }
    }
}