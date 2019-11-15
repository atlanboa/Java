package digitalMart;

public class Tv {
	private String dsn;
	private String name;
	private int price;
	private int amount;
	private String inch;
	private String type;
	
	public Tv(String dsn, String name, int price, int amount, String inch, String type) {
		super();
		this.dsn = dsn;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.inch = inch;
		this.type = type;
	}

	public String toString() {
		return dsn + "," + name + "," + price + "," + amount + "," + inch + "," + type;
		}

}
