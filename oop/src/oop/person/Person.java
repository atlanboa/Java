package oop.person;

public class Person {//Person의 식구 세 명
	public String name;
	public String toYou;
	
	public Person() {} //메소드의 선언부는 구성요소로 보지 않음...
	public void personInfo() {
		System.out.println(toYou);
		System.out.println("저는," + name + "입니다.");
	}
}
