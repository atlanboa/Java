package condition.test;

import java.util.Scanner;

/*
 * Operator
 * 
 * 
 * 
 */

public class PatternGameTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int tmp = 0;
		int cnt = 0;
		while(tmp > 0) {
			int num = tmp % 10;
			if(num % 3 == 0) {
				cnt++;
			}
			tmp = tmp / 10;
		}
		if(cnt == 0) {
			System.out.println(n);
		}
		else {
			while(cnt > 0) {
				System.out.print("@");
				cnt--;
			}
			System.out.println();
		}
	}
}
