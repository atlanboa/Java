package com.ssafy.service;

import com.ssafy.child.Instructor;
import com.ssafy.child.Manager;
import com.ssafy.child.Student;
import com.ssafy.parent.SSAFYResource;

public class SSAFYResourceService3 {

	/*
	 * 관리하는 메소드를 이렇게 하면 안되는 이유?
	 * 극단적인 예, 저렇게 하면 안됨
	 * 직관적으로 다른 메소드로 보임 ---> 같은거임
	 * 소스코드는 가독성이 매우 중요함
	 * 
	 * 가장 안좋은 방법임
	 */
//	public void studentManage(Student st) {
//		
//	}
//	
//	public void insService(Instructor i) {
//		
//	}
//	
//	public void managera(Manager m) {
//		
//	}
//	
	
	//하는 일은 같지만 처리하는 타입이 다를 때 -- > 오버로딩해야지
	//이름은 뭐할까? manage 별로임 왜? 뭘 manage하는지 모름
	//도메인은 겁나 많음 누굴 서비스할지 모름 -> 싸피리소스매니지 해야함
	
	//step2
//	public void ssafyManage(Student st) {}
//	public void ssafyManage(Instructor i) {}
//	public void ssafyManage(Manager m) {}
	/*
	 * 메소드 몇개? 3개지만 다 같은 일을 하는 메소드로 보임
	 * 서비스클래스는 도메인클래스의 정보를 출력하는 역할할꺼임 -> 그럼 프린트엘엔은 테스트가 아닌 저기 서비스에서 해야함
	 * 그럼 리턴타입은? String 하지마 ㅠㅠㅠ 이젠 객체로 할꺼임
	 */
	
	//step3 그래도 여전히 메소드 3개니까 인자값을 뭘로한다? 부모객체로
	//public void ssafyManage(SSAFYResource ssafy) {}
	//아규먼트는 인자값 매개변수임
	//부모타입으로 인자값해서 자식 여러종류를 쓸수 있음
	//이게 폴리몰픽 아규먼트임
	public void ssafyManage(SSAFYResource ssafy) {
		
		//if(ssafy Instructor)
		/*
		 * 부모타입으로 선언해서 실질적으로 만들어진게 인스트럭터라면
		 * 이걸 명시하기 위해서 instanceof 키워드씀
		 */
		if(ssafy instanceof Instructor) { //부모타입으로 생성된 객체가 instructor라면
			((Instructor)ssafy).changeSubject("자바");
			
			
		}else if(ssafy instanceof Manager) {
			((Manager) ssafy).changeDept("마케팅부");
		}
		
		
		
	    	System.out.println(ssafy);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
