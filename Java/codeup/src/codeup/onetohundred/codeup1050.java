package codeup.onetohundred;
import java.util.Scanner;

public class codeup1050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String arg[] = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        if (a == b) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}