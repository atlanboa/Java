package array.basic.test;

class Person{
	String name;
	int age;
}
public class BasicArrayTest1 {

	public static void main(String[] args) {
		Person p = new Person(); //클래스 타입으로 p라는 객체가 생성
		                         //메모리에 Field값들이 올라감
		
		
		//1. 배열 선언 + 생성
		int[] arr = new int[3]; //size 명시 필수!!...주소값...묵시적 초기화
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n클래스의 주소값::" + p);
		System.out.println("배열의 주소값 :: " + arr);
		
		//2. 명시적 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		for(int n : arr) {
			System.out.println(n);
		}
		
		System.out.println("===========================");
		
		arr = new int[5];
		arr[3] = 44;
		arr[4] = 55;
		
		for(int n : arr) {
			System.out.println(n);
		}
	}

}
