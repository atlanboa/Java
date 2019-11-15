package abcDigital.domain;

public class Refrigerator extends Product {
	private int liter;
	
	//Constructor
	public Refrigerator() {}
	
	public Refrigerator(int liter) {
		super();
		this.liter = liter;
	}

	public Refrigerator(String serial, String name, int price, int amount, int liter) {
		super(serial, name, price, amount);
		this.liter = liter;
	}

	//getters and setters
	public int getLiter() {
		return liter;
	}

	public void setLiter(int liter) {
		this.liter = liter;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "liter=" + liter + " ";
	}
	
	
	
	
	
}
