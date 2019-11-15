package looping.test;

import java.util.Scanner;

public class StairsTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		stairscase(n);
	}

	private static void stairscase(int n) {
		// TODO Auto-generated method stub
		for(int i = n - 1; i >= 0; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.print(" ");				
			}
			for(int k = i; k < n; k++) {
				System.out.print("#");
			}
			System.out.println();			
		}
	}
}
