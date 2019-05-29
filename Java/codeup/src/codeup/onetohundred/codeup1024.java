package codeup.onetohundred;

import java.util.Scanner;

public class codeup1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        if (data.length() == 21) { return; }
        for (int i = 0; i < data.length(); i++){
            System.out.println("'"+data.charAt(i)+"'");
        }
    }
}

