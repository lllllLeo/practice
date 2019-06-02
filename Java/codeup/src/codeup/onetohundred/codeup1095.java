package codeup.onetohundred;

import java.util.Scanner;

public class codeup1095 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String t = sc.nextLine();
        String num = sc.nextLine();
        String arg[] = num.split(" ");
        int temp = 0;
        temp = Integer.parseInt(arg[0]);
        for (int i = 0; i < arg.length; i++) {
            if (temp > Integer.parseInt(arg[i])){
                temp = Integer.parseInt(arg[i]);
            }
        }
        System.out.print(temp);
    }
}
