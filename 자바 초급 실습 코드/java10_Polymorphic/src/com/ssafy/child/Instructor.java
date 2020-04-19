package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Instructor extends SSAFYResource{
	private String subject;

	public Instructor(String name, int age, String address, String subject) {
		super(name, age, address);
		this.subject = subject;
	}

	public Instructor() {	}
	
	public void changeSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return super.toString()+" Subject=" + subject;
	}

	
}






