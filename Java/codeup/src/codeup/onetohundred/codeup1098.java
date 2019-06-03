package codeup.onetohundred;

import java.util.Scanner;

public class codeup1098 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String wh = sc.nextLine();
        String arg[] = wh.split(" ");
        int w = Integer.parseInt(arg[0]);   // 가로
        int h = Integer.parseInt(arg[1]);   // 세로
        int n = sc.nextInt();   // 막대 개수
        sc.nextLine();
        int result[][] = new int[w][h];
//        출력
        for (int i = 1; i <= n; i++) {   // 개수만큼 돈다
            String nldxy = sc.nextLine();
            String temp[] = nldxy.split(" ");
            int l = Integer.parseInt(temp[0]);   // 막대 길이
            int d = Integer.parseInt(temp[1]);   // 가로0, 세로1 여부
            int x = Integer.parseInt(temp[2]);   // 막대 가장 왼쪽 위 x좌표
            int y = Integer.parseInt(temp[3]);   // 막대 가장 왼쪽 위 y좌표
            System.out.println(l + " " + d + " " + x + " " + y);
            result[x][y] = 1;
            System.out.println(result[x][y]);
            for (int m = 1; m < w; m++) {   // 가로
                for (int j = 1; j < h; j++) {   // 세로
                    if (d == 0) {
                        for (int k = 1; k <= l; k++) {   // in 가로
                            result[x][y] = 1;
                            x++;
                            break;
                        }
                    } else if (d == 1) {
                        for (int k = 1; k <= l; k++) {   // in 세로
//                        result[j][k] = result[x][y];
                            result[x][y] = 1;
                            y++;
                            break;
                        }
                    } else {
                        result[x][y] = 0;
                    }
                }
//                    System.out.println(result[x][y]+" ");
                break;
            }
        }
    }
}

