package com.ssafy.test;

import com.ssafy.child.Engineer;
import com.ssafy.child.Manager;
import com.ssafy.child.Secretary;
import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

public class InheritanceTest2 {

	public static void main(String[] args) {
		
		Employee e = new Employee("James", 40000.0, new MyDate(1960, 2, 3));
		Manager m = new Manager("Gosling", 35000.0, new MyDate(1983, 4, 12), "개발부");
		
		System.out.println(e);
		System.out.println(m); 
		
		
		Employee e1 = new Manager("강호동", 40000, new MyDate(1960, 2, 3), "anjdla");
		Employee e2 = new Engineer("김포동", 1, new MyDate(1960, 2, 3), "기술부");
		/*
		 * 엔지니어한테는 보너스가 있었다잉 그건 세터로 했자나
		 */
//		((Engineer) e2).setBonus(300); //오버라이딩만 그러한거고 e2는 임플로이 객체니까 임플로이 타입이지  setBonus는 엔지니어 만의 메소드자나 그럼 엔지니어 타입일때 가능하지 -> 그래서 캐스팅을 해줘야함
//		//괄호 잘봐야함 캐스팅 잘 꼬아서 낼 수 있음
//		
		//(Engineer)e2; 이게 캐스팅한거임
		
		Engineer eg = (Engineer)e2;
		eg.setBonus(300);
		
		((Manager)e1).setDept("기획부");
		
		
		
		
		Employee e3 = new Secretary("강호동", 100, new MyDate(1960, 2, 3), "강호동");
		//이렇게
		//부모타입으로 자식 객체 만들 수 있음 물론 새로 만들어지는건 매니저 엔지니어 ... 
		
		System.out.println(e1); //toString생략되어잇음 누구의 toString? 부모의 toString 
								//왜? e1 e2 e3가 임플로이 타입이자나 그럼  오락부 기술부 강호동이 안나와야지 
		System.out.println(e2); 
		System.out.println(e3); 
		
		//e1 e2 e3 객체변수는 Employee 타입으로 선언된 변수이다.
		//그렇기 때문에 각각 선언된 클래스의 toString()이 호출된다 -- 그럼 오락부 기술부 강호동 안나와야하자나? 나오는 이유는
		//toString() 메소드가 상속관계의 클래스에서 오버라이딩되어진 메소드 이기 때문이다.
		
		//즉 다시말해서 부모타입으로 자식객체를 생성하고 + 그 객체변수로 오버라이딩 된 메소드를 호출하는 경우에는
		//--> Virtual Method Invocation 원리가 작동함
		//이게 뭐냐면
		/*
		 * 1)compile time type 컴파일메소드 일때는 부모의 메소들을 호출함 그래서 네임 샐러리 벌스데이만 리턴함 그다음...그럼 자식꺼에서 훅 올라옴
		 * 그걸 실행때는 자식메소드를 다시호출함
		 * 2)run time type 실행메소드 이때는 자식의 메서드를 호출함
		 * 오버라이딩하면서 부모메소드와 자식메소드가 링킹 되어잇기 때문에 훅킹이 가능 끌어올려짐
		 * 
		 */
		
		
		
		
		System.out.println("Heterogeneous");
		
		
		
		
		
	}

}
