package staticExam.test;

public class StaticExamTest3 {
	static int i;
	
	public static void main(String[] args) {
		System.out.println("main method static block.... 메인도 스태틱임" +i);
		//메인에서 무슨 일해 주로?
		/*
		 * 객체생성함 -> 생성자 호출 -> 초기화함
		 * static은 생성자보다 더 먼저 돌아감
		 * static 블록보다 더 먼저돌아가는거 있다? 없음 이게 제일 최초임
		 * 대표적인 작업 : 나중에 디비연결할꺼임
		 * 디비연결할려면 드라이버 로딩작업이 필요한데 그걸 static이라 함
		 * 
		 */
	}
	
	//Q.위치는 여기여야하나? 클래스 안이어도 됨
	static {
		//얘가 메인보다 먼저 실행되네?
		//여기는 static 초기화 block임
		i++;
		System.out.println("static block.... 메인도 스태틱임" +i);
	}

}
