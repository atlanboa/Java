package collection.set.test;

import java.util.HashSet;
import java.util.Set;

public class SetTest1 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("강호동");
		set.add("강호동");
		set.add("이수근");
		set.add("서장훈");
		
		System.out.println(set); //중복이 되는지 안되는지 확인하는 방법 뭐게?
		System.out.println(set.size()); //3이 나오면 강호동 중복안되었다는 뜻 알고리즘에서 숫자 빠짐없이 넣을 때 쓰겠네 1부터 9까지 숫자 넣으면 사이즈가 9보다 작으면 안됨
		
		boolean find = set.contains("이수근");
		
		set.remove("서장훈");
		System.out.println(set.size());
		
		set.clear();
		System.out.println(set.isEmpty());
	}

}
