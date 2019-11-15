package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Manager extends SSAFYResource{
	private String dept;

	public Manager(String name, int age, String address, String dept) {
		super(name, age, address);
		this.dept = dept;
	}

	public Manager() {	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString()+" dept=" + dept;
	}

	
}






