package com.ssafy.java;

import java.util.Random;

public class Lotto {
	
	public static void main(String[] args) {
		boolean[] chk = new boolean[46];
		for(int i = 0; i < 6; i++) {
			Random r = new Random();
			int a = r.nextInt(45) + 1;
			if(!chk[a]) {
				chk[a] = true;
				System.out.print(a + " ");
			}
			else {
				i--;
			}
		}
		System.out.println();
	}

}
