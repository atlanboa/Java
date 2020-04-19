
package edu.jaen.java.xml.sax;

import java.util.List;

public class CheckSAXTest {

	public static void main(String[] args) {
		
		
		List<Check> list = 
		new CheckSAXParser().getContent("http://127.0.0.1:8888/result.xml"); //한번만 할꺼면 이렇게 해도됨
		
		for(Check c : list) {
			System.out.println(c);
		}
	}

}
