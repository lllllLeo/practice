package codeup.onetohundred;

import java.util.Scanner;

public class codeup1064 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] arg = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        int c = Integer.parseInt(arg[2]);
        System.out.println((a<b ? b : a ) < c ? (a>b? b : a) : c);
    }
}
