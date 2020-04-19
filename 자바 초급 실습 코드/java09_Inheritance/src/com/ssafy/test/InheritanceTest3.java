package com.ssafy.test;

import com.ssafy.child.Engineer;
import com.ssafy.child.Manager;
import com.ssafy.child.Secretary;
import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class InheritanceTest3 {

	public static void main(String[] args) {
		
		Employee e = new Employee("James", 40000.0, new MyDate(1960, 2, 3));
		Manager m = new Manager("Gosling", 35000.0, new MyDate(1983, 4, 12), "개발부");
		Employee e1 = new Manager("강호동", 40000, new MyDate(1960, 2, 3), "anjdla");
		Employee e2 = new Engineer("김포동", 1, new MyDate(1960, 2, 3), "기술부");
		Employee e3 = new Secretary("강호동", 100, new MyDate(1960, 2, 3), "강호동");
		
		Engineer eg = (Engineer)e2;
		eg.setBonus(300);
		
		((Manager)e1).setDept("기획부");
	
		
		System.out.println("Heterogeneous Collection");
		System.out.println("이기종간의 집합체");
	// 지금 객체 몇개 만듬? 5개
		// 다 담으려면 무슨 타입으로 담아야할까? 임플로이, 부모
		Employee[] earr = {e,m,e1,e2,e3};
		
		for(Employee n : earr) {
			System.out.println(n); //toString 생략되어있고 자식정보 다나옴
		}
		
		
	}

}
