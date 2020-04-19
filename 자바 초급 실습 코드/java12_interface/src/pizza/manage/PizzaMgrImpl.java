package pizza.manage;

import java.util.ArrayList;

import pizza.parent.Pizza;

//싱글톤 해야지
public class PizzaMgrImpl implements PizzaMgr{

	private static PizzaMgrImpl mgr = new PizzaMgrImpl();
	private PizzaMgrImpl() {
		// TODO Auto-generated constructor stub
	}
	public static PizzaMgrImpl getInstance() {
		return mgr;
	}
	
	
	
	//무조건 강제적으로 오버라이딩 해야함
	@Override
	public void allMakePizza(ArrayList<Pizza> list) {
		// TODO Auto-generated method stub
		for(Pizza p : list) {
			p.orderMaking(); //하나의 피자가 만들어지는 전체 과정이 나오겠지?
			
			System.out.println("=========================");
			
			
			
			
			
			
			
		}
	}

}
