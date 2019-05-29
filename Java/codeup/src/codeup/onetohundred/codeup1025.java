package codeup.onetohundred;

import java.util.Scanner;

public class codeup1025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println("[" + data.charAt(0)+"0000" + "]");
        System.out.println("[" + data.charAt(1)+"000" + "]");
        System.out.println("[" + data.charAt(2)+"00" + "]");
        System.out.println("[" + data.charAt(3)+"0" + "]");
        System.out.println("[" + data.charAt(4)+ "]");
        
    }
}

