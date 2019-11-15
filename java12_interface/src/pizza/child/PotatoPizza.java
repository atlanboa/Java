package pizza.child;

import pizza.parent.Pizza;

public class PotatoPizza extends Pizza {

	//슈퍼클래스 해야 나옴
	public PotatoPizza(int price, String storeName) {
		super(price, storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void topping() {
		System.out.println("감자 토핑");
		
	}

}
