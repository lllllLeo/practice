package codeup.onetohundred;
import java.util.Scanner;

public class codeup1067 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if (data%2 == 0) {
            if (data < 0 ) {
                System.out.println("minus");
            } else {
                System.out.println("plus");
            }
            System.out.println("even");
        } else {
            if (data < 0 ) {
                System.out.println("minus");
            } else {
                System.out.println("plus");
            }
            System.out.println("odd");
        }
    }
}
