package broker.exception;

public class InvalidTransactionException extends Exception {

	public InvalidTransactionException() {
		this("This is InvalidTransactionException...");
	}
	public InvalidTransactionException(String msg) {
		super(msg);
	}
}
