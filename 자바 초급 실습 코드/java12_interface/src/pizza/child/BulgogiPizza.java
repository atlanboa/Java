package pizza.child;

import pizza.parent.Pizza;

public class BulgogiPizza extends Pizza {

	//슈퍼클래스 해야 나옴
	public BulgogiPizza(int price, String storeName) {
		super(price, storeName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void topping() {
		System.out.println("불고기 토핑");
		
	}

}
