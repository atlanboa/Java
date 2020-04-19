package com.ssafy.child;

import com.ssafy.parent.SSAFYResource;

public class Student extends SSAFYResource{
	private int javaScore;
	private int algoScore;
	
	public static final int DEFALUT_JAVA = 60;
	public static final int DEFALUT_ALGO = 60;
	
	public Student(String name, int age, String address, int javaScore, int algoScore) {
		super(name, age, address);
		this.javaScore = javaScore;
		this.algoScore = algoScore;
	}
	public Student() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, String address) {
		this(name, age,address,DEFALUT_JAVA,DEFALUT_ALGO);
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public int getAlgoScore() {
		return algoScore;
	}
	public void setAlgoScore(int algoScore) {
		this.algoScore = algoScore;
	}
	@Override
	public String toString() {
		return "Student [javaScore=" + javaScore + ", algoScore=" + algoScore + "]";
	}	
}
