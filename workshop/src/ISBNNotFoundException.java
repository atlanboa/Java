
public class ISBNNotFoundException extends Exception {
	ISBNNotFoundException(){
		this("ISBN Null");
	}

	public ISBNNotFoundException(String string) {
		super(string);
	}
}
