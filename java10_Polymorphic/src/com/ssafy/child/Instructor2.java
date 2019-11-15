package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Instructor2 extends SSAFYResource {
	private String dept;

	public Instructor2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor2(String name, int age, String address) {
		super(name, age, address);
		// TODO Auto-generated constructor stub
	}

	public Instructor2(String dept) {
		super();
		this.dept = dept;
	}


}
