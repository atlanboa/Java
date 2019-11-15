package com.ssafy.parent;
//parent class임

//도메인
//encapsulation
//생성자 기본으로 만들고
//세터 게터도 같이 만들고
//toString도 함

public class SSAFYResource2 {
	
	
	public SSAFYResource2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public SSAFYResource2(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	private String name;
	private int age;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "SSAFYResource [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
}
