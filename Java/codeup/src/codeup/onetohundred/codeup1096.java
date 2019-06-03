package codeup.onetohundred;

import java.util.Scanner;

public class codeup1096 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        String enter = sc.nextLine();
        int xy [][] = new int[20][20];
        for (int i = 0; i < line; i++) {
            String data = sc.nextLine();
            String arg[] = data.split(" ");
            int a = Integer.parseInt(arg[0]);
            int b = Integer.parseInt(arg[1]);
            xy[a][b] = 1;
        }
        for (int j = 1; j < xy.length; j++) {
            for (int k = 1; k < xy.length; k++) {
//                if (xy[j][k] == 1) {
//                    System.out.print(1+" ");
//                    continue;
//                }
//                System.out.print(0+" ");
                System.out.print(xy[j][k]+" ");
            }
            System.out.println();

        }
    }
}
