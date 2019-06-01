package codeup.onetohundred;

import java.util.Scanner;

public class codeup1079 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");

        for (int i = 0; i < arg.length; i++) {
            System.out.println(arg[i]);
            if (arg[i].equals("q")){ return; }
        }
    }
}