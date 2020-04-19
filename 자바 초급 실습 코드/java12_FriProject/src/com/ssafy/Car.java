package com.ssafy;

public class Car {
	//필드
	private String num;
	private String model;
	private int price;
	
	//생성자 
	public Car() {}
	
	public Car(String num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}
	
	//메소드(게터 세터)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [num=" + num + ", model=" + model + ", price=" + price;
	}
	
	
	
	
	
	
	
	
	
	
	
}
