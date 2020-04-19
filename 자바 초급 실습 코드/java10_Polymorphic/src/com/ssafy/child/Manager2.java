package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Manager2 extends SSAFYResource {
	private String subject;

	public Manager2(String name, int age, String address, String subject) {
		super(name, age, address);
		this.subject = subject;
	}
	
	public Manager2() {
		// TODO Auto-generated constructor stub
	}
	
}
