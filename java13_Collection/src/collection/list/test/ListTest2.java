package collection.list.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest2 {

	public static void main(String[] args) {
		//어지간하면 제네릭 해주는게 좋음 아니면 오브젝트로 받기 때문에 캐스팅해줘야하는 번거로움
		//Polymorphism 됨
		//ArrayList<String> list = new ArrayList<String>(); 도 됨
		List<String> list = new ArrayList<String>(); //이렇게 많이 씀
		list.add("이효리");
		list.add("옥주현");
		list.add("이진");
		list.add("성유리");
		list.add("이진");
		
		System.out.println(list); //Collection은 toString() 오버라이딩
		
		String rName = list.remove(2);
		System.out.println(rName + "님이 삭제");
		
		//삭제로직은 리턴타입이 중요함 삭제된 객체가 리턴됨
		
		//직접 객체를 언급하면 리턴이 불리온임
		if(list.remove("성유리")) System.out.println("delete ok");
		System.out.println(list);
		
		System.out.println(list.get(0));
		
		list.set(2, "아이유");
		System.out.println(list);
		
	}

}
