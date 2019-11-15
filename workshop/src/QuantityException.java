
public class QuantityException extends Exception {
	QuantityException(){
		this("Quantitu Zero");
	}

	public QuantityException(String string) {
		super(string);
	}
}
