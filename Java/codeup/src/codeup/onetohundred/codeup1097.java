package codeup.onetohundred;
import java.util.Scanner;

public class codeup1097 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int xy [][] = new int[20][20];
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                int a = sc.nextInt();
                xy[i][j] = a;
            }
            sc.nextLine();
        }
        int line = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < line; i++) {
            String data = sc.nextLine();
            String arg[] = data.split(" ");
            int a = Integer.parseInt(arg[0]);
            int b = Integer.parseInt(arg[1]);
            for (int j = 1; j < 20; j++) {
                if (xy[a][j] == 1) {
                    xy[a][j] = 0;
                } else { xy[a][j] = 1; }
            }
            for (int j = 1; j < 20; j++) {
                if (xy[j][b] == 1) {
                    xy[j][b] = 0;
                } else { xy[j][b] = 1; }
            }
        }
        for (int j = 1; j < 20; j++) {
            for (int k = 1; k < 20; k++) {
                System.out.print(xy[j][k]+" ");
            }
            System.out.println();
        }
    }
}
