package flyer;
/*
 * 기능의 Template만을 모아놓은 틀
 * 특징 필드를 가지지 않는다 static한거 아니자나 필드는
 * interface의 구성요소
 * 1) 구현부가 없는(그래서 ;로 끝남) --> 그걸 추상메소드라 함
 */
public interface Flyer {
	int speed = 140; //필드 안가진다며? 근데 왜 되노? 잘 보면 변수가 없으로 누움
					//public static final이 무조건 박힘 변수에는
					//public static final이 무조건 생략됨
	
	void fly(); //public abstract 생략되있는 거임
	public abstract void land();
	void take_off();
}

//하나라도 구현 안된 메소드가 있으면 추상클래스가 된다
/*
 * 인터페이스는 완벽한 추상이야. 맞아? 응
 * 모든 기능이 템플릿으로 이뤄져있어야함
 * 그럼 클래스는? 완벽한 설계도임
 * 객체는 완벽한 설계도에서 생성되야함
 * 미완에서는 객체생성 안됨
 * 
 * 이 둘사이 가운데 추상클래스가 있음 그럼 인터페이스와 추상클래스의 차이는???
 * <추상클래스와 인터페이스의 차이는?>
 * 인터페이스는 필드가 없음 -> 물려줄 대상이 아니라는 것, 즉 상속의 대상이 아님
 * 추상클래스는 상속의 대상이 되는 존재임 그래서 extends안쓰고  implements쓰나보다!!!
 * 이러한 미완의 대상인 추상클래스는 상속의 대상이 됨
 * 
 * 추상클래스와 클래스의 용도는?
 * 1.추상클래스는 객체생성이 안됨
 * 객체생성이 안된다는건? '부모'로서만 존재함 super로서만 존재하겠다는 성질이 굉장히 굉장히 명확함
 * 객체생성 대상이 아니라는 것 강압적으로 상속의 의미를 가짐
 * 
 * 2.근데 구멍을 내놨네?
 * 티비마다 이름, 종류, 해상도가 다름
 * 결정적으로 다른 부분을 추상메소드로 만듬
 * 그럼 무조건 오버라이딩 해야하자나 
 * 나머지 공통적인 성질은 물려주는 거임
 * 그래서 abstract로 물려줘야함
 * 결정적으로 다른 지점이 있는 애들은 구멍을 뚫어놔 그다음 상속받으면 자기에게 맞게 오버라이딩 해야함
 * 
 * 불완전해 -> 잘모르는거
 * 아 너무 강압적이야 -> 잘 아는거임
 * 구멍을 메꿔야하거든 무조건
 * 
 */

class Eagle extends Bird{

	//무조건해야함 f2엔터 눌러봐서 알겠지만
	@Override
	public void land() {
		System.out.println("구현해놔야지");
		
	}
	
	//나머지는 오버라이딩 하겠습니다.
	@Override
	public void take_off() {
		System.out.println("bird fly");
		
	}
	
	//더만들수있음
	public String layEggs() {
		return "알을 깐다";
	}

	
}






abstract class Bird implements Flyer{
	String nest = "숲속에서";
	@Override
	public void fly() {
		//speed = 100; //에러남 못씀 그대로 써야함
		System.out.println("bird fly");
		
	}

	/*
	 * 왜 에러남? 구현안해서
	 * 다른말 public abstract void land(); 그럼 요렇게있는거지?
	 *  구현안할려면 abstract 붙이면 에러안남
	 */
//	@Override
//	public void land() {
//		System.out.println("bird fly");
//		
//	}

	@Override
	public void take_off() {
		System.out.println("take off");
		
	}
	
	//더만들수있음
	public String layEggs() {
		return "알을 깐다";
	}







}