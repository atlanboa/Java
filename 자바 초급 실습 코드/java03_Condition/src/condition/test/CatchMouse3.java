package condition.test;

import java.util.Scanner;

public class CatchMouse3 {

		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int catA = sc.nextInt();
		int catB = sc.nextInt();
		int mouse = sc.nextInt();

		int cata_m = Math.abs(catA - mouse);
		int catb_m = Math.abs(catB - mouse);

		if(cata_m == catb_m) {
			System.out.println("Mouse Escapes!!");
		}
		else if(cata_m < catb_m) {
			System.out.println("CatA Catch!");
		}
		else {
			System.out.println("CatB Catch");
		}
	}
}
