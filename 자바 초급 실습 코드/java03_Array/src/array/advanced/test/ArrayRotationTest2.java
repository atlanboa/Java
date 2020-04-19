package array.advanced.test;

import java.util.Arrays;

/*
 * *Test1의 예제에서 만약에
 * 1. 배열의 길이가 10000개 이상이고
 * 2. 회전의 횟수도 100000번 이상이라면
 * 
 * 이전처럼 로직을 작성한다면 timeout이 발생할 여지가 있다.
 * 어떤 방법을 사용할까?
 * 
 */

public class ArrayRotationTest2 {

	public static void main(String[] args) {
//		int[] arr = {20,30,50,70,90};
//		int rcnt = 2;
//		int[] index = {2, 0 ,1};
		
		int[] arr = new int[10000];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		int rcnt = 100000;
		int[] index = {2, 0, 1};
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
		
		int rotationRemain = rcnt % arr.length;
		for(int i = 0; i < rotationRemain; i++) {
			krotation(arr);
		}
		int[] result = new int[index.length];
		for(int i = 0; i < result.length; i++) {
			result[i] = arr[index[i]];
		}
		return result;
	}

}
