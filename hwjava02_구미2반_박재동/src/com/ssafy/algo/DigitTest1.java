package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ans = new int[10];
		while(true) {
			int N = sc.nextInt();
			if(N == 0) break;
			if(N < 10) {
				ans[0]++;
				continue;
			}
			N /= 10;
			ans[N]++;
			
		}
		for(int i = 0; i < 10; i++) {
			if(ans[i] != 0) {
				System.out.println(i + " : " + ans[i] + "개");
			}
		}

	}

}
