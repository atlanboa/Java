package test;

import java.util.Scanner;

/*
 * 싱글톤
 * 
 * 하나의 클래스로부터 오직 단 한개의 객체만 생성하도록 함
 * 단 한개 만들어놓은 객체를 여러 다른 클래스들이 서로 공유해서 사용하는 패턴
 * 다이렉트로 접근하는 것이 아니라 기능만 씀!!!!
 * 요청마다 다른 메소드 씀
 * 
 * 
 * 싱글톤 작성하는 로직의 순서
 * 1.일단 묻지도 따지지도 말고 해당 클래스에서 하나의 객체를 무조건 생성
 * 	private static Member mem = new Member();
 * 2.다른 곳에서는 이 클래스로 객체생성 못하도록 막아둔다
 * 3.객체생성과 관련된 알고리즘은 뭐게? 생성자
 * 4.그럼 생성자 못만들게 하면 되지
 * 5.생성자 앞에 private 붙이면 딴데서는 생성자 못만들어 생성안됨
 * 6.하나 만들어 놓은 객체의 기능을 서로 공유해서 사용한다.
 * 7.기능을 공유하려면 객체를 받아와서 써야함
 * public ? Member getInstance()
 */
class SSAFYCompany{
	private String companyName = "";
	//1.
	private static SSAFYCompany ssafy = new SSAFYCompany();
	
	//2.
	private SSAFYCompany() {
		companyName = "SSAFY Association";
		System.out.println("companyName :" + companyName);
		
	}
	//3.만들어놓은 것을 딴데서 쓸 수 있도록 되돌려주는 메소드
	public static SSAFYCompany getInstance() {
		return ssafy;
	}
}



//딴데서 실험해보자
public class SSAFYCompanyTest {

	public static void main(String[] args) {
		
		//not visible = 있는데 못쓴다는 뜻 없는게 아니라
		//SSAFYCompany ssafy = new SSAFYCompany();
		/*
		 * 메소드 쓰려면 객체생성해야해 근데 지금 객체생성 못써....
		 * 객체생성을 못하게했어 그래서 메소드 못써 그럼 저걸 객체생성안하고 써야해
		 * 
		 * 메소드는 객체생성 과정없이 만들어 쓰려면 반드시 'static'이 중요함
		 * public ? Member getInstance()
		 * ? = static임 스태틱은 객체생성안하고 쓸 수 있음
		 * 
		 * static이 지정된 애들은(아주 중요햇) 여기서 애들은? 메소드와 필드
		 * 객체생성 과정없이 쓸 수 있다!!!!!!!!!
		 * 객체생성과정없이 쓸수 있다는건 암시적으로 객체생성하기전에 메모리에 미리 올라가있음 그때의 메모리는 힙이 아님 class area로 올라감
		 * 객체생성 이전에 메모리 이미 올라가잇음
		 * 자바는 두가지 단계 컴파일 단계 + 실행단계
		 * 쓸수 있다 = 메모리에 올라갔다 이때의 메모리는 힙임
		 * 
		 * 컴파일하고나면 실행파일이 만들어지자나 그래서 실행단계가면 거기 젤 첫번째 단계에서 로더됨
		 * 클래스파이 로더 단계에서 바로 올라감 스캐너의 system.in이 그런애들
		 */
		Scanner sc = new Scanner(System.in);
		//system.in이 의미하는 건? 키보드입력
		SSAFYCompany com1 = SSAFYCompany.getInstance();
		SSAFYCompany com2 = SSAFYCompany.getInstance();
		//이런 식으로 하면 계속 쓸수 있음 그런 com1 com2는 같은 객체일까 다른객체일까? 같은 객체임!!
		/*
		 * 확인해보자 어떻게? 출력해서 주소값같은지 보면 되지
		 */
		//다른데서 객체 생성못하게 하려면 생성자를 막으면됨
		System.out.println(com1);
		System.out.println(com2);
		
		/*
		 * 이렇게 들고와서 메소드를 주구장창 씀
		 * 리턴타입이 필요없는 메소드?
		 * add
		 * delete
		 * 근데 사실 리턴타입 필요없는 건 없음
		 * 얘네 둘은 데이터반환이 필요없는거 근데 됬는지 안됬는지 모르자나
		 * add, delete도 필요함 언제? 성공여부 확인할때
		 * 성공여부에 대한 응답을 반드시 해줘야하마
		 * 요청과 응답에서는 무조건 요청에 대한 응답 리턴값이 있어야한다. 
		 */
		
		
	}

}
