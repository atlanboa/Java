package multiple;
/*
 * 클래스와 클래스는 무슨관계임?
 * Dog extends Animal  ---> 상속관계임
 * 
 * 클래스와 인터페이스는 무슨관계?
 * Bird implements Flyer ---> 구현관계임
 * 
 * 인터페이스와 인터페이스는 무슨관계? ---> 상속관계
 * 둘사이에  implements 안되자나 구현해도 Attackable도 인터페이스자나 그니까 extends씀
 * 상속되면 뭐가됨? 기능이 강화됨
 * 
 * 인터페이스 구성요소? 추상메소드, 상수
 * 
 * jdk 8버전부터 업그레이드 된게있음
 * 만약 상속받았는데 그중에 두개만 쓰는데... 전부구현하면 귀찮자나
 * 그래서 디폴트로 해놓을수 잇는 기능생겼는데 알고만 있어
 * 
 * 
 * 
 */

public interface Movable {
	void moving();
	void moveX();
	void moveY();
	
}

interface Attackable extends Movable{ //기능강화
	void attack();
	void depense();
	
}

class Fighter implements Attackable{

	@Override
	public void moving() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveY() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depense() {
		// TODO Auto-generated method stub
		
	}
	
}