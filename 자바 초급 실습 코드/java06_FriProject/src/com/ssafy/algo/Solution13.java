package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

// dx, dy로 다시 짜보기

public class Solution13 {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int gCnt = 0; 
		int bCnt = 0;

		for(int test = 1; test <= T; test++) {
			int N = sc.nextInt(); //3~20

			String[][] arr = new String[N][N];
			int[][] count = new int[N][N];

			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {
					arr[n][m] = sc.next();
				}
			}


			//			for(int n = 0; n < N; n++) {
			//				for(int m = 0; m < N; m++) {
			//					System.out.print(arr[n][m]+ " ");
			//				}
			//				System.out.println();
			//			}
			//			


			for(int i = 0; i<arr.length; i++) {
				for(int j = 0; j<arr.length; j++) {
					gCnt = 0;
					if(arr[i][j].equals("B")) {
						for(int k = i-1; k<= i+1; k++) {
							for(int l = j-1; l<= j+1; l++) {

								if(k!=-1 && k!=N && l!=-1 && l!=N) {
									if(arr[k][l].equals("G")) gCnt++; 	
								}

							}		
						}


						if(gCnt > 0) {
							count[i][j] = 2;
						}
						else {

						}
					}

					else if(arr[i][j].equals("G")) {
						count[i][j] = -99;
					}
				}
			}

			//			for(int n = 0; n < N; n++) {
			//				for(int m = 0; m < N; m++) {
			//					System.out.print(count[n][m]+ " ");
			//				}
			//				System.out.println();
			//			}
			//			
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {
					if(count[n][m] == 0) {
						bCnt = 0;
						for(int i = 0; i<arr.length; i++) {
							if(arr[i][m].equals("B")) bCnt++;
						}
						for(int j = 0; j<arr.length; j++) {
							if(arr[n][j].equals("B")) bCnt++;
						}

						count[n][m] = bCnt - 1;


					}
				}

			}

			//			for(int n = 0; n < N; n++) {
			//				for(int m = 0; m < N; m++) {
			//					System.out.print(count[n][m]+ " ");
			//				}
			//				System.out.println();
			//			}
			//			
			int max = count[0][0];

			for(int n = 0; n < N; n++) {
				for(int m = 0; m < N; m++) {

					if(max < count[n][m]) {
						max = count[n][m];
					}
				}

			}

			System.out.println("#" + test + " " + max );



		}
	}

}
