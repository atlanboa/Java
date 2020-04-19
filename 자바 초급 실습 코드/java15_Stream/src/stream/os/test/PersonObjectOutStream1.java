package stream.os.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable{
	private String name;
	private int age;

	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age= age;
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
	
	
	
	
}

public class PersonObjectOutStream1 {

	
	public static void main(String[] args) throws IOException {
		String fileName = "person.obj";
		FileOutputStream fos = new FileOutputStream(fileName);
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Person p = new Person("김연아", 27); //김연아 27 데이터가 직렬화해서 날라감
		
		oos.writeObject(p);
		
		oos.close();
		
		System.out.println("person.obj 파일에 연아에 대한 정보를 출력함");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
