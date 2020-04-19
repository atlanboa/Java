package com.ssafy.test;

import java.util.ArrayList;

import com.ssafy.child.Instructor;
import com.ssafy.child.Manager;
import com.ssafy.child.Student;
import com.ssafy.parent.SSAFYResource;
import com.ssafy.service.SSAFYResourceService;

public class SSAFYResourceServiceTest {

	public static void main(String[] args) {
	
		/*
		 * 여기서 생성해야 되는 객체는? 부모객채x
		 * 
		 * 서비스객체!!!!!
		 */
		
		SSAFYResourceService service = new SSAFYResourceService();
		
		service.addSSAFY(new Student("신혜진", 25, "대구"));
		service.addSSAFY(new Manager("제임스", 35, "구평동", "교육부"));
		service.addSSAFY(new Student("신혜진", 25, "대구"));
		service.addSSAFY(new Instructor("고슬링", 45, "인동", "파이썬"));
		
		ArrayList<SSAFYResource> returnList = service.getAllMember();
		for(SSAFYResource r : returnList) {
			System.out.println(r);
		}
	}

}
