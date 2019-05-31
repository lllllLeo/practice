package codeup.onetohundred;


import java.util.Scanner;

public class codeup1069 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        char data = sc.next().charAt(0);

        switch (data) {
            case 'A' :
                System.out.println("best!!!");  break;
            case 'B' :
                System.out.println("good!!"); break;
            case 'C' :
                System.out.println("run!");  break;
            case 'D' :
                System.out.println("slowly~"); break;
            default :
                System.out.println("what?");
        }
    }
}
