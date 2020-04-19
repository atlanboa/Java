package collection.property.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest1 {
	public static void main(String[] args) {
		//vm에 탑재되어있는 환경변수 출력해볼래
		/*
		 * Properties를 모르면 당황
		 * 얘는 Map임 -> key value 가짐
		 */
		Properties p = System.getProperties();
		
		//<String>안하면 에러 안남
		Enumeration en =  p.propertyNames();
		//마우스 포커스가 있는곳 다 훑을 수 있음
		//돌아가는 횟수를알면 for 모르고 다 뽑아내려면 
		while(en.hasMoreElements()) { //이면
			String name = (String)en.nextElement();
			String value = p.getProperty(name);
			
			System.out.println(name + "\t======== " + value);
		}
	}

}
