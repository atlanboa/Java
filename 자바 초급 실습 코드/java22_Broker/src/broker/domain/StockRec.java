package broker.domain;
/*
 * stock 테이블의 정보를 저장하는 클래스
 */
public class StockRec {

	private String symbol;
	private double price;
	
	public StockRec() {}
	public StockRec(String symbol, double price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockRec [symbol=" + symbol + ", price=" + price + "]";
	}
	
	
}