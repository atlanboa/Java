package pizza.parent;
/*
 * 추상클래스의 용도
 * ::
 * 상속의 용도로 이해하는 것이 바람직하다
 * 두가지 측면이 있지
 * 1.여러 종류의 피자를 만들 때 피자가 가지는 공통적인 성질은 그대로 물려준다.
 * 2.여러 종류의 피자를 만들 때 서로 다른 피자가 만들어지는 결정적인 부분은 '구멍으로' 물려준다. 이때 말하는 구멍은 추상메소드를 말함
 * 
 */
abstract public class Pizza {
	protected int price;
	protected String storeName;
	
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(int price, String storeName) {
		super();
		this.price = price;
		this.storeName = storeName;
	}
	
	public void orderMaking() {
		//피자 순서대로 해야하니까 명시해줌
		dough();
		topping();
		baking();
		cut();
		box();
	}
	
	public void dough() {
		System.out.println("dough만든다");
	}
	
	public void cut() {
		System.out.println("8등분으로 자른다.");
	}
	
	public void baking() {
		System.out.println("화덕에서 구움");
	}
	public void box() {
		System.out.println("상자를 만든다");
	}
	
	//void topping(); 왜 에러날까
	
	public abstract void topping();
}