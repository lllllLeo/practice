package codeup.onetohundred;

import java.util.Scanner;

public class codeup1020 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String pAdd = sc.nextLine();

        String[] arg = pAdd.split("-");

        System.out.println(arg[0]+arg[1]);
    }
}

