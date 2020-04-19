package com.ssafy.parent;

import com.ssafy.util.MyDate;

//abstract해도 에러 안남 
/*
 * 추상클래스 용도는 ? super로 존재 상속
 * 이거 abstract보면 아 얘는 super구나 끝 객체생성 될일이 없을 때
 */
/*abstract */public class Employee {
	private String name;
	private double salary;
	private MyDate birthdate;

//	public Employee() {
//		
//	}
	public Employee(String name, double salary, MyDate birthdate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthdate = birthdate;
	}

//	public String getDetails() {
//		return name + "," + salary + "," +birthdate/*생략되어잇음 객체변수에는.toString()*/; //클래스 타입은 출력하면 주소값나옴 그래서 필드를 리턴해주는 메소드인 겟데이터씀
//	}
//	
	@Override
	public String toString() {  //위에 getDatils가 필요없어짐
		return name + "," + salary + "," +birthdate.getDate();
	}
}
