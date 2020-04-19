package condition.test;

import java.util.Scanner;

public class ParentwithTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "";//메소드 블락 안에서 선언... 지역(로컬)변수... 반드시 초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력...");
		int age = sc.nextInt();
		
		System.out.println("보호자가 동반합니까?");
		boolean withParent = sc.nextBoolean();
		/*
		 * 19세 초과라면 ~세, 관람 가능합니다. 
		 * 
		 * 19세 이하라면 
		 * 	  부모 동반했다면 관람 가능
		 * 	  부모 동반 안했다면 관람 불가능
		 *   를 출력
		 */
		
		if(age > 19) {
			message = "관람 가능";
		}
		else {
			if(withParent) {
				message = "미성년자지만 부모동반했기에 관람 가능";
			}
			else {
				message = "부모 동반 안했기에 관람 불가능";
			}
		}
		
		System.out.printf("나이 : %d, 보호자 동반여부: %b, 결과 : %s",age, withParent, message);
		
	}
}
