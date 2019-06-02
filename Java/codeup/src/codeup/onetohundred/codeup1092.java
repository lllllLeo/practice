package codeup.onetohundred;

import java.util.Scanner;
// || 해야지 &&로 찾으니까
public class codeup1092 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg [] = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        int c = Integer.parseInt(arg[2]);
        int day = 1;
        while (day%a!=0 || day%b!=0 || day%c!=0) {
            day++;
        }
        System.out.println(day);
    }
}
