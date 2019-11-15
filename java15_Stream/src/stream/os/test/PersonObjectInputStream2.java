package stream.os.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class PersonObjectInputStream2 {

	
	public static void main(String[] args) throws Exception  {
		String fileName = "person.obj";
		
		//1.스트림 생성해봐
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		//2.읽어들인다
		Person p = (Person)ois.readObject();
		//3.읽어들인 정보를 콘솔로 출력
		System.out.println(p);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
