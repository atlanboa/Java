package com.ssafy.child;


import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private int bonus;
		
	//생성자는 객체가 '생성'될 때 호출하는 알고리즘
	public Engineer(String name, double salary, MyDate birthdate, String tech) {

		super(name, salary, birthdate); //부모 기본 생성자 호출 이거 왜 일어남??? 부모가 없으면 자식도 없자나 우리가 존재하려면 부모가 필요하자나 부모 객체가 생성되있어야함 생성자는 객체를 만드는거

		this.tech = tech;

		
		
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	//이건 오버라이딩
	public String toString() {
		return super.toString() + ", " + tech; //변하는게 뭐야? 자식클래스안의 메소드의 '기능'이 바뀜 -> 새로운 메소드로 봄 -> 그래서 우리나라 번역본에서는 메소드 재정의라함
 	}
	
	//이건 오버로딩
}