package codeup.onetohundred;

import java.util.Scanner;

// 소수점 11자리 뽑고 출력하니까 %.11f로 출력하니까 6자리 때부터 반올림돼서 자바에서는 어쨰하는지 몰겠다. 그냥 string으로 그대로 받아서 출력함
public class codeup1029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.printf(data);
    }
}

