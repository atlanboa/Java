package sort.test;

import java.util.ArrayList;
import java.util.Collections;

/*
 * String, wrapper, date, file 클래스들은 (나중에 api 봐) 기본적으로 Comparable 인터페이스에 의해
 * 상속받은채로 정의되어진 클래스들이다.
 * Comparable에 의해서 구현된 클래스들은 같은 타입의 객체값은 서로 비교해서 정렬할 수 있다.
 * 기본적으로 오름차순으로 정렬된다.
 * 
 * 배열을 다룰때 쓰니는 클래스 Arrays 여기에 Arrays.sort(배열)은 사실상 Comparable에 의해서 정렬된 것임
 * 근데 우리 이제 리스트씀 특히나 순서대로 쓰려면  ArrayList쓰는데 얘는 Arrays.sort()로 정렬이 안된다
 * 우리가 쓰는건 배열이아니라 콜렉션임 이제
 * ===================================================
 * 학생들의 성적순으로 정렬해서 출력하시오 나올 수 잇어 이때 배열이 아니므로 sort 못씀
 * 이때 comparable 써야함
 * 한번더꼬우면 내림차순으로 하라할껄?
 * 
 * ArrayList는  Collections.sort()로 정렬한다.
 *///////////////////////////////////////////////////////////////////////
 
// 1.Comparable을 직접구현하는 방법 ... 이 인터페이스 상속받으면 compareTo를 구현해야함
class Person implements Comparable<Person>{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}



//	@Override
//	public int compareTo(Person p) {
//		// TODO Auto-generated method stub
//		return name.compareTo(p.getName());
//	}
//	
	public int compareTo(Person p) {
		// TODO Auto-generated method stub
		//스트링은 객체라서 된거고 int인 age도 객체로 만들어줘야함
		//return "selkf".compareTo("aaa");
		return (new Integer(age).compareTo(p.getAge())); //이건 스트링일때도 됨 //이거 뭐야???? 원리가 뭐야?????
		//return new Integer(age).compareTo(-(p.getAge())); 이건 스트링일때는 못함
	}
	
}
public class ComparableTest1 {

	public static void main(String[] args) {
		
		ArrayList<Person> list = new ArrayList<>();
		list.add(new Person("이정재", 44));
		list.add(new Person("하정우", 43));
		list.add(new Person("조인성", 38));
		
		Collections.sort(list);
		System.out.println(list);
		
		//지금 이름으로 sorting되었음
	}

}
