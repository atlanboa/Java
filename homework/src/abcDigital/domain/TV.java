package abcDigital.domain;

public class TV extends Product {
	private int inch;
	
	//Constructor
	public TV() {}
	
	public TV(int inch) {
		super();
		this.inch = inch;
	}

	public TV(String serial, String name, int price, int amount, int inch) {
		super(serial, name, price, amount);
		this.inch = inch;
	}

	//getters and setters
	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	//toString
	@Override
	public String toString() {
		return super.toString() + "inch=" + inch + " ";
	}
	
	
	
	
	
}
