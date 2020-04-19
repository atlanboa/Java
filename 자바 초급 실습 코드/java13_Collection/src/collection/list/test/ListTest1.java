package collection.list.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest1 {

	public static void main(String[] args) {
	
		List<String> list = new ArrayList<String>(); //이렇게 많이 씀
		list.add("이효리");
		list.add("옥주현");
		list.add("이진");
		list.add("성유리");
		list.add("이진");
		
		for(String s : list) System.out.println(s);
		System.out.println("===============");
		/*
		 * iterator()는 콜렉션 객체를 (지금은 리스트)
		 * 리스트 객체를 Iterator로 변환해서 반환시킴
		 * Iterator는 커서를 이용해서 컬렉션의 모든 데이터를 순차적으로 접근해서 Sorting해줌
		 * 결론적으로 Collection Vue 역할을 한다고 보면 됨
		 * 자료구조 많자나 콜렉션 종류 많자나 거기에 데이터를 넣었어
		 * 
		 * 그걸 핸들링해야지 이제
		 * 
		 * Enumeration
		 * hasNextElements()
		 * nextElement()
		 * 
		 * 얘보다 좀 더 나은 애가 생겼음                    Iterator
		 * 								hasNext()
		 * 								next()
		 * 	   							 + remove() 추가됨             훨씬 좋은게 또나옴 자식 인터페이스임      
		 * 커서가 훑으면서 Sorting하는 역할밖에 없음 뒤로 못돌아가고 다 끝나면 소멸됨
		 * 다시 훑으려면 다시 만들어야함
		 * 
		 *  																			ListIterator 인터페이스의 상속은?? 기능강화임
		 *  																			 hasPrevious() //양방향 검색이 가능해짐
		 *  																			 previous()
		 *  																			 add()
		 *  																			 set()얘는 아마 수정기능임
		 */
		Iterator<String> it =  list.iterator();
		//아까 배웠던 Enumeration? 그거랑 비슷 해즈넥스트엘레먼츠~! 이면 넥스트엘레먼츠
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
