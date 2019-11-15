package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int so = sc.nextInt();
		int[][] pond = new int[N][N];
		int jump = 3+2+1;
		int sCnt = 0;

		for(int i = 0; i < so; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int dir = sc.nextInt();
			pond[row][col] = dir;

			switch(dir) {
			case 1:
				if(row-jump > -1) {
					if(pond[row-jump][col] != 99) {
						pond[row][col] = 0;
						pond[row-jump][col] = 99;
					}
				}

				break;

			case 2:
				if(row+jump < N) {
					if(pond[row+jump][col] != 99) {
						pond[row][col] = 0;
						pond[row+jump][col] = 99;
					}
				}

				break;

			case 3:
				if(col-jump > -1) {
					if(pond[row][col-jump] != 99) {
						pond[row][col] = 0;
						pond[row][col-jump] = 99;
					}
				}

				break;

			case 4:
				if(col+jump < N) {
					if(pond[row][col+jump] != 99) {
						pond[row][col] = 0;
						pond[row][col+jump] = 99;
					}
				}


				break;




			}

		}

		//		for(int i = 0; i < pond.length; i++) {
		//			for(int j = 0; j < pond.length; j++) {
		//				System.out.print(pond[i][j] + " ");
		//			}
		//			System.out.println();
		//		}
		//		
		//		for(int i = 0; i < pond.length; i++) {
		//			for(int j = 0; j < pond.length; j++) {
		//				if(pond[i][j] > 0) {
		//					
		//				}
		//				
		//			}
		//		}

		for(int i = 0; i < pond.length; i++) {
			for(int j = 0; j < pond.length; j++) {
				if(pond[i][j] == 99) {
					sCnt++;
				}
			}

		}

		System.out.println("ekq : " + sCnt);
	}

}
