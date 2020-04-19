package broker.exception;

public class DuplicateSSNException extends Exception {

	public DuplicateSSNException() {
		this("This is DuplicateSSNException...");
	}
	public DuplicateSSNException(String msg) {
		super(msg);
	}
}
