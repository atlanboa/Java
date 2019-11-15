package com.ssafy.parent;
//Parent class...
public class SSAFYResource3 {
	private String name;
	private int age;
	private String address;	
	
	public SSAFYResource3(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public SSAFYResource3() {	}
	
	
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
	public String attend() {
		return "출석";
	}
	@Override
	public String toString() {
		return "SSAFYResource [name=" + name + ", age=" + age + ", address=" + address + "]";
	}	
}







