package pizza.test;

import java.util.ArrayList;

import pizza.child.BulgogiPizza;
import pizza.child.PineapplePizza;
import pizza.child.PotatoPizza;
import pizza.manage.PizzaMgrImpl;
import pizza.parent.Pizza;

public class PizzaMgrImplTest {

	public static void main(String[] args) {
		PizzaMgrImpl mgr = PizzaMgrImpl.getInstance();
		ArrayList<Pizza> list = new ArrayList<>();
		
		list.add(new PotatoPizza(12000, "Mister"));
		list.add(new BulgogiPizza(18000, "Pizza Hut"));
		list.add(new PineapplePizza(22000, "domino"));
		
		mgr.allMakePizza(list);
		
	}

}
