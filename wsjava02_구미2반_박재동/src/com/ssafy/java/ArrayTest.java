package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {34, 23, 64, 25, 12, 75, 22, 88, 53, 37};
		
	
		print(arr);
		total(arr);
		average(arr);
		minimum(arr);
	}
	
	private static void print(int[] a) {
		for(int i = 0; i < 10; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	private static void total(int[] a) {
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += a[i];
		}
		System.out.println("배열의 합:" + sum);
	}
	private static void average(int[] a) {
		int sum = 0; int avg = 0;
		for(int i = 0; i < 10; i++) {
			sum += a[i];
		}
		avg = sum / a.length;
		System.out.println("배열의 평균:" + avg);
	}
	private static void minimum(int[] a) {
		int mini = 987654321;
		for(int i = 0; i < 10; i++) {
			if(mini > a[i]) {
				mini = a[i];
			}
		}
		System.out.println("배열의 최소값:" + mini);
	}

}
