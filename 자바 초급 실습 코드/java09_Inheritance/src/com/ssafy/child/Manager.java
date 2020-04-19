package com.ssafy.child;
//자식클래스 child sub Class라 함

import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class Manager extends Employee {
	private String dept;

	
	/** 에러 왜 났을까?
	public Manager(String name, double salary, MyDate birthdate, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthdate = birthdate;
		this.dept = dept;
	}
	*/
	//생성자는 객체가 '생성'될 때 호출하는 알고리즘
	public Manager(String name, double salary, MyDate birthdate, String dept) {
		//자식생성자 첫라인에 무조건 super가 옴 왜?
		super(name, salary, birthdate); //부모 기본 생성자 호출 이거 왜 일어남??? 부모가 없으면 자식도 없자나 우리가 존재하려면 부모가 필요하자나 부모 객체가 생성되있어야함 생성자는 객체를 만드는거
//		this.name = name; //여기는 왜 에러나? this는 객체의 주소값(레퍼런스값)을 갖고있댔음 매니저에 name 찾으러 갔더니 없엉.... 물려줬다매? 아니야 dept만 있자나 
//		this.salary = salary;
//		this.birthdate = birthdate;//못쓰는 데다가, private이라 다른 클래스에서 못쓰자나
		this.dept = dept;
		
		
		//그럼, 부모클래스에 메소드가 있을 때는 반드시 super(부모메소드, 부모메소드, )일케 해줘야함????
		
		
		/*
		 * 이게 바로 Method Overriding
		 * 1. 상속 관계에 있는 두 클래스에서 적용되는 원리
		 * 2. 1) 부모가 가진 기능을 물려 받고
		 * 	  2) 그걸 자식이 다시 고쳐쓰는 것 -> 해당 메소드의 내용이, 기능이 바뀌었다
		 * 
		 * <Rule>
		 * 1. 메소드 선언부는 모두 일치해야함 (리턴타입, 이름, 인자값) 접근지정자는 언급안했음 아직
		 * 2. 메소드 구현부는 반드시 달라야한다(인자값의 순서, 타입, 갯수중 하나라도 달라야함)
		 * ex) 부모가 가진 메소드 parent public void eat(String kind, String num){
		 * 				
		 * 				   child  void eat(String kind, String num){ 이건 오버라이딩 아님
		 * 3. More Modifier / Less Exception 자식은 부모보다 접근지정자가 더 크던지 같던지 해야함
		 * 
		 *  parant void go()
		 *  child  public void go() more modifier이기 때문에 이건 됨
		 *  
		 *  시험에 메소드 오버라이딩 오버로딩 섞어서 나올 것 같음
		 */
		
		
		
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	//이건 오버라이딩
	public String toString() {
		return super.toString() + ", " + dept; //변하는게 뭐야? 자식클래스안의 메소드의 '기능'이 바뀜 -> 새로운 메소드로 봄 -> 그래서 우리나라 번역본에서는 메소드 재정의라함
 	}
	
	//이건 오버로딩
	public String toString(String subclass) {
		
		System.out.println("해당클래스는"+subclass+"입니다"); //이건 찌개다시?? 구현부 똑같은거 ??????
		
		return super.toString() + ", " + dept; //변하는게 뭐야? 자식클래스안의 메소드의 '기능'이 바뀜 -> 새로운 메소드로 봄 -> 그래서 우리나라 번역본에서는 메소드 재정의라함
 	}
	
	
//	public String toString() {
//		return super.toString() + "오버라이딩 됨???";
//	}
}
