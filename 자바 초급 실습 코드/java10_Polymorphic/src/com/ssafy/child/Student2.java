package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Student2 extends SSAFYResource {

	public Student2(String name, int age, String address) {
		super(name, age, address);
		// TODO Auto-generated constructor stub
	}

	private int javaScore;
	private int alogScore;
	public static final int DEFAULT_JAVA = 60;
	
	
	public Student2() {
		// TODO Auto-generated constructor stub
	}
	
	//이 학생은 점수가 없는 학생임
	public Student2(String name, int age, String address, int javaScore, int alogScore) {
		super(name, age, address);
		this.javaScore = javaScore;
		this.alogScore = alogScore;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	public int getAlogScore() {
		return alogScore;
	}

	public void setAlogScore(int alogScore) {
		this.alogScore = alogScore;
	}

	@Override
	public String toString() {
		return "Student [javaScore=" + javaScore + ", alogScore=" + alogScore + "]";
	}
	
}
