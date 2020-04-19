package array.advanced.test;

import java.util.Arrays;

/*
 * 1. arr이라는 이름의 배열이 주어짐
 * 2. 시계방향으로 회전을 k번 진행.... k는 1~100000번
 * 3. k번만큼 회전한 결과 배열의 인덱스에 해당하는 값을 출력
 *    하는 문자열 출력
 *    시계방향으로 1번 회전... 90,20,30,50,70
 *    int[] index = {2, 0, 1};
 */

public class ArrayRotationTest {

	public static void main(String[] args) {
		int[] arr = {20,30,50,70,90};
		int rcnt = 2;
		int[] index = {2, 0 ,1};
		
		int[] result = circularArrayRotation(arr, rcnt, index);
		System.out.println(Arrays.toString(result));
		
	}

	static void krotation(int[] arr) {
		int temp = arr[arr.length - 1];
		for(int i = arr.length -1; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}
	private static int[] circularArrayRotation(int[] arr, int rcnt, int[] index) {
		for(int i = 0; i < rcnt; i++) {
			krotation(arr);
		}
		int[] result = new int[index.length];
		for(int i = 0; i < result.length; i++) {
			result[i] = arr[index[i]];
		}
		return result;
	}

}
