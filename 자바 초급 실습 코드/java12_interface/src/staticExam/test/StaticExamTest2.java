package staticExam.test;
/*
 * static 성질 정의
 * 1.static한 성질을 가지는 멤버는 객체생성 과정이 필요없다.
 *                        -----------------
 *                        이 말은 객체생성하지 않아도 메모리에 올라간다는 뜻
 *                        객체생성 시점보다 훨씬 전에 미리 올라가있다는 뜻
 *                        객체생성 이전에 미리 메모리에 올라간다. 언제? 자바는 컴파일 단계, 실행단계 두 단계 있다.
 *                        컴파일 단계엔 뭐하는데? 바이트코드로 만듬, 성공하면 그렇겠지
 *                        문법체크--> 모든 '타입'을 다 체크함 그게 OK되면 실행파일이 만들어지고 실행이 진행됨
 *                        그럼 실행단계 젤 첫번째에서 class file loader 과정이 일어남
 *                        클래스 파일이 메모리에 로더될때 그때 올라간다\
 *                        static은 객체 레퍼런스 값이랑 상관 없음--> 절대 만날 수 없는 키워드 : this
 *                        static 블락안에서는 절대로 this 사용 못한다
 *                        
 * 2.static은 static끼리 통한다
 * 3.static은 필드 레벨로만 사용가능하다
 * 4.static변수, 클래스변수라 불리운다. 다른 랭기지에서의 전역변수를 말함
 * 5.Math.abs();
 * 	 Integer.parseInt();
 *   String.format();
 *   System.in
 */
public class StaticExamTest2 {

	static String name = "홍길동";
	int age = 19;
	String address = "진평동";
	
	static void member() {
		name = "김민정";
		//필드니까 메모리에 아직 안올라와 있음
		//메모리 올라가는 시점 차이임----------> 2번특징
	}
	public static void main(String[] args) {
		//static int value = 200;
		//왜 에러나지?
		//로컬레벨에선 못씀

		StaticExamTest2 test1 = new StaticExamTest2();
		System.out.println(StaticExamTest2.name); //이렇게 접근해야지 근데 이렇게 하면 모든 사람의 이름이 김석용이 됨
		System.out.println(test1.name); //우리 모두가 쓸수 있는 값을 경도가 자기 이름으로 쉐어링 하는 거임 
	}

}
