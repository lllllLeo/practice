package main;

import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		Gugudan gugudan = new Gugudan();
		Scanner sc = new Scanner(System.in);

		int num;

		while (true) {
			System.out.println("원하는 구구단의 숫자를 입력하세요");
			num = sc.nextInt();

			if (num == 100) {
				gugudan.horizontalPrint();
			}else if(num == 200) {
				gugudan.verticalPrint();
			} else {
				gugudan.gugu(num);
			}
		}
	}

	public void gugu(int num) {
		System.out.println(num + "단입니다.\n");
		for (int i = 1; i < 10; i++) {
			System.out.println(num + " x " + i + " =" + num * i);
		}
	}

	public void horizontalPrint() {
		int i, j;
		for (j = 1; j < 10; j++) {
			for (i = 2; i < 10; i++) {
//				System.out.println("["+i+"단]");
				System.out.print(i + " x " + j + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}

	public void verticalPrint() {
		int i, j;
		for (i = 2; i < 10; i++) {
			System.out.print("["+i+"단] ");
			for (j = 1; j < 10; j++) {
				System.out.print(i + " x " + j + " = " + i * j + "\t");
			}
			System.out.println();
		}
	}
}
