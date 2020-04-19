package collection.list.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest3 {

	public static void main(String[] args) {
	
		ArrayList<String> list = new ArrayList<String>(); //이렇게 많이 씀
		
		list.add("서울");
		list.add("상해");
		list.add("동경");
		list.add("뉴욕");
		list.add("부산");//이 하나가 부분 리스트라서 

		list.add(1, "LA");//0번 인덱스인 서울 다음에 나오겟지
		System.out.println(list);
		
		list.remove("동경");
		System.out.println("확인");
		System.out.println(list.contains("LA")); //LA 대소문자 구분?하네!!! 안보게 하려면? String에 ignore 케이스 쓰려면?
												//Q.얘는 이꼴즈랑 다르게 포함아니엇음????
		
		Object[] obj = list.toArray(); //리스트 객체를 일반 배열로 변환
		System.out.println(Arrays.toString(obj));//리스트 toString() 오버라이딩
		
		String[] cities = new String[0]; //배열 사이즈 0되나? 가능합니다.
		//System.out.println(cities);
		
		
		cities = list.toArray(cities);//리스트에있는 데이터를 스트링 타입으로 변환한다
	
		//얘뭐임? 배열로받음?
		//System.out.println(Arrays.toString(cities)); //데이터 개수가 늘어남
		
		list.clear();
		System.out.println(list.isEmpty());//현재 리스트는 텅텅비었다 
		
		//비어있는 리스트에 다시 데이터를 추가
		list.add("파리");
		list.add("싱가폴");
		list.add("부다페스트");
		
		//Arrays 클래스는 어떤 클래스임? 배열 데이터 처리에 다양한 기능을 제공하는 클래스임
		//toString, sort 이런거 많이씀
		/*
		 * asList() 메소드는 인자로 전달된 데이터를 가지는  List 객체를 생성해서 반환함
		 * 
		 */
		//Arrays.asList("전주", "경주", "진주"); //얘네를  List로 반환함 제네릭은 뭐임? 스트링임
		List<String> list2 = Arrays.asList("전주", "경주", "진주");
		
		list.addAll(list2);//list + list2
		System.out.println(list);
		
		System.out.println(list.containsAll(list2)); //list에 list2의 내용이 있는지의 여부 판단
		
		list.retainAll(list2);//list에서 list2만 남기고 나머지는 다 버림 일종의 차집합???
		System.out.println(list);
		
		list.removeAll(list);
		System.out.println(list);
		
		
		
	}

}
