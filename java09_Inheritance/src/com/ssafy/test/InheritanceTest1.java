package com.ssafy.test;

import com.ssafy.child.Manager;
import com.ssafy.parent.Employee;
import com.ssafy.util.MyDate;

class Test{
	int aaa = 0;
	
}



public class InheritanceTest1 {

	public static void main(String[] args) {
		
		Test t = new Test();//얘는 객체변수 참조변수
		System.out.println(t);
		System.out.println(t.toString());
		System.out.println(t.hashCode()); //16진수로 주소값나옴
		
		Employee e = new Employee("James", 40000.0, new MyDate(1960, 2, 3));
		Manager m = new Manager("Gosling", 35000.0, new MyDate(1983, 4, 12), "개발부");
		
		System.out.println(e/*.getDetails()*/);
		System.out.println(m/*getDetails()*/); //개발부 왜 안나옴? 이 메소드는 부모거임 그래서 부모가보면  dept
											//상속에서 기능상의 부분은 자식에게 맞게 새로 하는게 더 나음
		
		System.out.println(m.toString()); //그럼 이제 get 디테일 안써도됨
	}

}
