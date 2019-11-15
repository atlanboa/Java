package digitalMart;

public class Refrigerator {
	private String dsn;
	private String name;
	private int price;
	private int amount;
	private int liter;
	
	
	public Refrigerator(String dsn, String name, int price, int amount, int liter) {
		super();
		this.dsn = dsn;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.liter = liter;
	}


	public String toString() {
		return dsn + "," + name + "," + price + "," + amount + "," + liter;
		}
}
