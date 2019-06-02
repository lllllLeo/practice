package codeup.onetohundred;

import java.util.Scanner;
public class codeup1093 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String t = sc.nextLine();
        String num = sc.nextLine();
        String arg[] = num.split(" ");
        int answer[] = new int[23];
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < line; j++) {
                if (Integer.parseInt(arg[j])==i+1) {
                    answer[i] = answer[i] + 1;
                }
            }
        }
        for (int a : answer) {
            System.out.print(a+" ");
        }
    }
}
