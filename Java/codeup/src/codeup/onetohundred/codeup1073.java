package codeup.onetohundred;

import java.util.Scanner;

// 1071이랑 똑같이함 귀찮네
public class codeup1073 {
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