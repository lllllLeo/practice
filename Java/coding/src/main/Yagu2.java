package main;

import java.util.Scanner;

public class Yagu2 {
	int com[] = new int[3];
	int user[] = new int[3];
	int strike;
	int ball;
	int count = 10;
	
	public void userNum() {
		int i;
		Scanner sc = new Scanner(System.in);
		for (i = 0; i < user.length; i++) {
			try {

				System.out.println((i + 1) + "번째 숫자를 입력하세요");
				user[i] = sc.nextInt();

				if (user[i] > 9) {
					System.out.println("1~9 숫자만 입력이 가능합니다.");
					i -= 1;
				}

				if (i == 1) {
					if (user[0] == user[1]) {
						System.out.println("같은 숫자를 입력할 수 없습니다. 다시 입력해주세요.\n");
						i -= 1;
					}
				}

				if (i == 2) {
					if (user[1] == user[2] || user[0] == user[2]) {
						System.out.println("같은 숫자를 입력할 수 없습니다. 다시 입력해주세요.\n");
						i -= 1;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력이 가능합니다.");
				i -= 1;
			}

		}
	}

	public void computer() {
		int i, j;
		for (i = 0; i < com.length; i++) {
			com[i] = (int) (Math.random() * 9) + 1;

			for (j = 0; j < i; j++) { // ㅅㅂ com[i]를 i대신 썼었네 그래서 인덱스바운즈오브익셉션뜸
				if (com[i] == com[j]) {
					i -= 1;
					break;
				}
			}
		}
		for (i = 0; i < com.length; i++) {

			System.out.println("컴퓨터가 정한 숫자는" + com[i]);
		}
	}

	public void strikeOrBall() {
		int i, j;
		strike = 0;
		ball = 0;
		count--;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				if (com[i] == user[j]) {
					if (i == j) {
						System.out.println("strike 입니다.");
						strike++;
					} else {
						System.out.println("ball 입니다.");
						ball++;
					}
				}
			}
		}
		if(strike == 0 && ball == 0) {
			System.out.println("아웃 입니다.");
		}
		
	}

	public static void main(String[] args) {
		Yagu2 yagu2 = new Yagu2();
		
		yagu2.computer();
		while (true) {
			yagu2.userNum();
			yagu2.strikeOrBall();

			if (yagu2.strike == 3) {
				System.out.println("지렷구요");
				return;
			}
			System.out.println("현재 " + yagu2.strike + " strike /" + yagu2.ball + " ball 입니다.");
			System.out.println("기회는 "+ yagu2.count+"번 남았습니다.");
		}
	}
}
