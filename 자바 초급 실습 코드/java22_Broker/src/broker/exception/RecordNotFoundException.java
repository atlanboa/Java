package broker.exception;

public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String msg) {
		super(msg);
	}
	public RecordNotFoundException() {
		this("This is RecordNotFoundException...");
	}
}
