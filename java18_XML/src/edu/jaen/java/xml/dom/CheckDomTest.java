package edu.jaen.java.xml.dom;

import java.util.List;


public class CheckDomTest {

	public static void main(String[] args) {
		List<Check> list = new CheckDOMParser().getContent("http://127.0.0.1:8888/result.xml"); //한번만 할꺼면 이렇게 해도됨
				
				for(Check c : list) {
					System.out.println(c);
				}
	
	}

}
