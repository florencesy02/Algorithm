package chap02;

import java.util.Scanner;

public class algobook49p {

	public static void main(String[] args) {
		
		// 입력 받기 
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		
		// 함수
		npira(num);

	}
	
	static void npira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (2 * i) - 1; k++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
