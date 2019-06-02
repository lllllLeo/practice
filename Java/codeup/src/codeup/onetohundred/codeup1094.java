package codeup.onetohundred;

import java.util.Scanner;
public class codeup1094 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String t = sc.nextLine();
        String num = sc.nextLine();
        String arg[] = num.split(" ");

        for (int i = arg.length; i > 0; i--) {
            System.out.print(arg[i-1]+" ");
        }
    }
}
