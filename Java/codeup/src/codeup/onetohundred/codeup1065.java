package codeup.onetohundred;

import java.util.Scanner;

/*       메모리  시간
* if문   14240    95
* for문  14284    87
* */
public class codeup1065 {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] arg = data.split(" ");
        int a = Integer.parseInt(arg[0]);
        int b = Integer.parseInt(arg[1]);
        int c = Integer.parseInt(arg[2]);

        if (a%2 == 0) {
            System.out.println(a);
        }

        if (b%2 == 0) {
            System.out.println(b);
        }

        if (c%2 == 0) {
                    System.out.println(c);
                }

//        for (int i = 0; i < arg.length; i++) {
//            if (Integer.parseInt(arg[i])%2 == 0) {
//                System.out.println(arg[i]);
//            }
//        }
    }
}
