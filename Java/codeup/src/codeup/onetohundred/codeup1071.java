package codeup.onetohundred;

import java.util.Scanner;

// 원래 goto쓰는 문제인데 안씀
public class codeup1071 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] arg = data.split(" ");
        for (int i = 0; i < arg.length; i++) {
            System.out.println(arg[i]);
            if (arg[i].equals("0")) {
                return;
            }
        }
    }
}