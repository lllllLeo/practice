package main;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {

		int computer[] = new int[3];
		int user[] = new int[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < computer.length; i++) {
			computer[i] = (int) (Math.random() * 9 + 1);
			for (int j = 0; j < i; j++) {
				if (computer[i] == computer[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < computer.length; i++) {
			System.out.println(computer[i]);
		}
		System.out.println("배열길이는 " + computer.length);

		while (true) {
			System.out.println("숫자를 입력해주세요");
			for (int i = 0; i < user.length; i++) {
				System.out.println((i+1)+"번째 숫자를 입력해주세요");
				user[i] = sc.nextInt();
				
				while (user[i] <= 0 || user[i] >= 10) {
					System.out.println("1~9까지의 숫자만 입력이 가능합니다.");
					System.out.println("다시 입력해주세요.");
					user[i] = sc.nextInt();
				}
				
			}
			

		}
	}

}
