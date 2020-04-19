package collection.map.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("강호동", 90);
		map.put("이수근", 80);
		map.put("서장훈", 100);
		map.put("이상민", 80);
		
		/*
		 * api 찾아보면서 해보기
		 */
		
		//1.map에서 키값만 받아옴
		Set<String> set = map.keySet();
		System.out.println(set); //정말 키만 담겨있는지 확인해보자 있네 근데 Set이라 순서대로는 안드감
		
		//2.set에 담긴 키들을 하나씩 뽑아서 키에 매핑된 value 값을 받아온다
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			//map.get(key); //여기에 키 집어넣으면 이게 밸류가 되지
			int value = map.get(key);
			System.out.println(key + " df " + value);
		}
		
		//3.총점, 평균점 리턴타입이 콜렉션이었음
		Collection<Integer> col =  map.values();
		System.out.println(col);
		int sum = 0;
	    Iterator<Integer> iter = col.iterator();
	    while(iter.hasNext()) {
	    	sum += iter.next();
	    }
	    
	    System.out.println("총점" + sum);
	    System.out.println("평균" + sum/map.size()); //사람 숫자만큼임 사이즈는!!!
	    System.out.println("최고점수" + Collections.max(col)); //Arrays와 비슷
	    System.out.println("최저점수" + Collections.min(col)); //
	    
	}

}
