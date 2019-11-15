package looping.test;


/*
 * 1~1000까지의 정수 중에서 3의 배수의 합을 구해서 최종적으로 출력
 * for 
 * sum 로컬변수 선언, 초기화
 * %
 * if
 * @@ 3의 배수가 아니라면 합산로직을 건너뛰도록 해주세요
 * 
 */
public class ContinueTest3 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			if(i % 3 != 0) continue;
			sum += i;
		}
		System.out.println("3의 배수의 합 : " + sum);
	}
}
