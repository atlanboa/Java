package abcDigital.domain;

import java.io.Serializable;

public class Product implements Serializable{
	private String serial;
	private String name;
	private int price;
	private int amount;
	
	//Constructor
	public Product() {}
	public Product(String serial, String name, int price, int amount) {
		super();
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	//getters and setters
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	//toString
	@Override
	public String toString() {
		return "Product serial=" + serial + ", name=" + name + ", price=" + price + ", amount=" + amount + " ";
	}
	
	
	

}
